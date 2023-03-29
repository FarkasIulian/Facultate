using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Adaugare_Radiografie : Form
    {
        public Adaugare_Radiografie(string selected_cnp)
        {
            InitializeComponent();
            txtCNP.Text = selected_cnp;
        }

        private void btnBrowse_Click(object sender, EventArgs e)
        {
            OpenFileDialog dlg = new OpenFileDialog();
            if(dlg.ShowDialog() == DialogResult.OK)
            {
                string numeImg = Path.GetFileName(dlg.FileName);
                txtImag.Text = numeImg;
            }
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            string connect = @"Data Source=DESKTOP-QK7EJKC\SQLEXPRESS;Initial Catalog=Pediatrie;Integrated Security=True";
            SqlConnection cnn = new SqlConnection(connect);
            cnn.Open();
            string stmt = "insert into Radiografii ([CNP], [Data], [Nume_imagine], [Diagnostic], [Comentarii]) values(@cnp, @d, @ni, @diag, @c)";
            SqlCommand sc = new SqlCommand(stmt, cnn);
            sc.Parameters.AddWithValue("@cnp", txtCNP.Text);
            sc.Parameters.AddWithValue("@d", dateTimePicker1.Value);
            sc.Parameters.AddWithValue("@ni", txtImag.Text);
            sc.Parameters.AddWithValue("@diag", txtDiag.Text);
            sc.Parameters.AddWithValue("@c", richTextBox1.Text);
            sc.ExecuteNonQuery();
            cnn.Close();
            this.DialogResult = DialogResult.OK;
            this.Close();
        }
    }
}
