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
    public partial class Vizualizare_pacient : Form
    {
        string cnp;
        public Vizualizare_pacient(string selected_cnp)
        {
            InitializeComponent();
            cnp = selected_cnp;

        }

        private void ShowImages()
        {
            PictureBox pb;
            int index = 0;
            flowLayoutPanel1.Controls.Clear();
            string connect = @"Data Source=DESKTOP-QK7EJKC\SQLEXPRESS;Initial Catalog=Pediatrie;Integrated Security=True";
            SqlConnection con = new SqlConnection(connect);
            con.Open();
            string stmt = "select * from radiografii where cnp='" + cnp + "'";
            SqlCommand sc = new SqlCommand(stmt, con);
            SqlDataReader dr = sc.ExecuteReader();
            while (dr.Read())
            {
                string poza = dr["nume_imagine"].ToString();
                string cale_poza = @"C:\Users\Iulian\Desktop\Radiografii\" + poza;
                pb = new PictureBox(); //genereare poza
                                       //setare proprietatie poze
                pb.Name = "Picture" + index.ToString();
                pb.SetBounds(0, 0, 90, 70);
                pb.BackColor = Color.Black;
                pb.SizeMode = PictureBoxSizeMode.Zoom;
                pb.Image = Bitmap.FromFile(cale_poza);
                pb.Tag = index++;
                flowLayoutPanel1.Controls.Add(pb);
                pb.Click += Pb_Click;
            }
            con.Close();
            sc.Dispose();
            dr.Close();
        }

        private void Pb_Click(object sender, EventArgs e)
        {
            PictureBox pic = (PictureBox)sender;
            pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
            pictureBox1.Image = pic.Image;
            pic.BorderStyle = BorderStyle.Fixed3D;
        }

        private void ShowData()
        {
            string connect = @"Data Source=DESKTOP-QK7EJKC\SQLEXPRESS;Initial Catalog=Pediatrie;Integrated Security=True";
            SqlConnection cnn = new SqlConnection(connect);
            cnn.Open();
            string tabel_date = "select * from Pacienti where cnp='" + cnp + "'";
            SqlDataAdapter da = new SqlDataAdapter(tabel_date, connect);
            DataSet ds = new DataSet();
            da.Fill(ds, "Pacienti");
            txtCNP.Text = cnp;
            txtNume.Text = ds.Tables[0].Rows[0][1].ToString();
            txtPrenume.Text = ds.Tables[0].Rows[0][2].ToString();
            txtSex.Text = ds.Tables[0].Rows[0][3].ToString();
            txtNumeM.Text = ds.Tables[0].Rows[0][4].ToString();
            txtNumeT.Text = ds.Tables[0].Rows[0][5].ToString();
            txtData.Text = ds.Tables[0].Rows[0][6].ToString();
            txtLoc.Text = ds.Tables[0].Rows[0][7].ToString();
            txtAPGAR.Text = ds.Tables[0].Rows[0][8].ToString();
            txtMedic.Text = ds.Tables[0].Rows[0][9].ToString();
            txtAntecedente.Text = ds.Tables[0].Rows[0][10].ToString();
            TimeSpan t = DateTime.Now.Subtract(DateTime.Parse(txtData.Text));
            int varsta = (int)(t.TotalDays) / 365;
            txtVarsta.Text = varsta.ToString();
            cnn.Close();
        }

        private void ShowConsult()
        {
            string connect = @"Data Source=DESKTOP-QK7EJKC\SQLEXPRESS;Initial Catalog=Pediatrie;Integrated Security=True";
            SqlConnection cnn = new SqlConnection(connect);
            cnn.Open();
            string tabel_date = "select * from Consultanti where cnp='" + cnp + "'";
            SqlDataAdapter da = new SqlDataAdapter(tabel_date, connect);
            DataSet ds = new DataSet();
            da.Fill(ds, "Consultanti");
            dataGridView1.DataSource = ds.Tables["Consultanti"].DefaultView;
            cnn.Close();
        }

        private void Vizualizare_pacient_Load(object sender, EventArgs e)
        {
            ShowImages();
            ShowData();
            ShowConsult();
        }

        private void btnOK_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
