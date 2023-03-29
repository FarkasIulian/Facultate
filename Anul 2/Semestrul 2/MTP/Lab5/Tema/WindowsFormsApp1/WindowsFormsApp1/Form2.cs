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
    public partial class Form2 : Form
    {
        string selected_cnp;
        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            refresh();
        }

        private void btnCauta_Click(object sender, EventArgs e)
        {
            string connect = @"Data Source=DESKTOP-QK7EJKC\SQLEXPRESS;Initial Catalog=Pediatrie;Integrated Security=True";
            SqlConnection cnn = new SqlConnection(connect);
            cnn.Open();
            string stmt = "Select * from Pacienti where nume ='" + txtCautat.Text + "'";
            SqlDataAdapter da = new SqlDataAdapter(stmt, cnn);
            DataSet ds = new DataSet();
            da.Fill(ds, "Pacienti");
            dataGridView1.DataSource = ds.Tables["Pacienti"].DefaultView;
            cnn.Close();
            da.Dispose();
            ds.Dispose();
        }

        private void btnAddPacient_Click(object sender, EventArgs e)
        {
            Adaugare_pacient adaugare = new Adaugare_pacient();
            adaugare.ShowDialog();
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            Environment.Exit(0);
        }

        private void btnAddConsult_Click(object sender, EventArgs e)
        {
            Adaugare_consultatie Consultatie = new Adaugare_consultatie(selected_cnp);
            Consultatie.ShowDialog(); 
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            selected_cnp = dataGridView1.CurrentRow.Cells[0].Value.ToString();
        }

        private void refresh()
        {
            string connect = @"Data Source=DESKTOP-QK7EJKC\SQLEXPRESS;Initial Catalog=Pediatrie;Integrated Security=True";
            SqlConnection cnn = new SqlConnection(connect);
            cnn.Open();
            string tabel_date = "select * from Pacienti";
            SqlDataAdapter da = new SqlDataAdapter(tabel_date, connect);
            DataSet ds = new DataSet();
            da.Fill(ds, "Pacienti");
            dataGridView1.DataSource = ds.Tables["Pacienti"].DefaultView;
            cnn.Close();
        }

        private void btnRefresh_Click(object sender, EventArgs e)
        {
            refresh();
        }

        private void btnAddRadio_Click(object sender, EventArgs e)
        {
            Adaugare_Radiografie radiografie = new Adaugare_Radiografie(selected_cnp);
            radiografie.ShowDialog();
        }

        private void btnViewPacients_Click(object sender, EventArgs e)
        {
            Vizualizare_pacient vizualizare = new Vizualizare_pacient(selected_cnp);
            vizualizare.ShowDialog();
        }
    }
}
