using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Adaugare_consultatie : Form
    {
        public Adaugare_consultatie(string cnp_selected)
        {
            InitializeComponent();
            txtCNP.Text = cnp_selected;

        }

        private void btnAddConsult_Click(object sender, EventArgs e)
        {
            string connect = @"Data Source=DESKTOP-QK7EJKC\SQLEXPRESS;Initial Catalog=Pediatrie;Integrated Security=True";
            SqlConnection cnn = new SqlConnection(connect);
            cnn.Open();
            string stmt = "insert into Consultanti ([CNP], [Data], [Simptome], [Diagnostic], [Tratament]) values(@cnp, @d, @s, @diag, @trat)";
            SqlCommand sc = new SqlCommand(stmt, cnn);
            sc.Parameters.AddWithValue("@cnp", txtCNP.Text);
            sc.Parameters.AddWithValue("@d", dateTimePicker1.Value);
            sc.Parameters.AddWithValue("@s", txtSimpt.Text);
            sc.Parameters.AddWithValue("@diag", txtDiag.Text);
            sc.Parameters.AddWithValue("@trat", txtTrat.Text);
            sc.ExecuteNonQuery();
            cnn.Close();
            this.DialogResult = DialogResult.OK;
            this.Close();
        }
    }
}
