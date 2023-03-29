using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Adaugare_pacient : Form
    {
        public Adaugare_pacient()
        {
            InitializeComponent();
        }

        public static bool checkCNP(string cnp)
        {
            if (cnp.Trim().Length != 13)
                return false;
            else
            {
                int s=cnp[0]- '0',a1 = cnp[1]-'0', a2 = cnp[2] - '0', l1 = cnp[3] - '0', l2 = cnp[4] - '0', z1 = cnp[5] - '0', z2 = cnp[6] - '0', j1 = cnp[7] - '0', j2 = cnp[8] - '0', n1 = cnp[9] - '0', n2 = cnp[10] - '0', n3 = cnp[11] - '0', cifc, u;
                //se extrage fiecare caracter in parte
                cifc = Convert.ToInt16(((s * 2 + a1 * 7 + a2 * 9 + l1 * 1 + l2 * 4 + z1 * 6 + z2 * 3 + j1 * 5 + j2 * 8 + n1 * 2 + n2 * 7 + n3 * 9) % 11));
                if (cifc == 10)
                {
                    cifc = 1;
                }
                u = Convert.ToInt16(cnp.Substring(12, 1));
                if (cifc == u)
                    return true;
                else
                    return false;
            }
        }

        public bool duplicate(string cnp)
        {
            string connect = @"Data Source=DESKTOP-QK7EJKC\SQLEXPRESS;Initial Catalog=Pediatrie;Integrated Security=True";
            SqlConnection cnn = new SqlConnection(connect);
            cnn.Open();
            string stmt = "Select cnp from Pacienti where cnp ='" + cnp + "'";
            SqlDataAdapter da = new SqlDataAdapter(stmt, cnn);
            DataSet ds = new DataSet();
            da.Fill(ds, "Pacienti");
            cnn.Close();
            da.Dispose();
            if (ds.Tables[0].Rows.Count != 0)
            {
                ds.Dispose();
                return true;
            }
            ds.Dispose();
            return false;
        }


        private void btnAdd_Click(object sender, EventArgs e)
        {
            if (txtCNP.Text != string.Empty)
            {
                string cnp = txtCNP.Text;
                if (!duplicate(cnp))
                {
                    string connect = @"Data Source=DESKTOP-QK7EJKC\SQLEXPRESS;Initial Catalog=Pediatrie;Integrated Security=True";
                    SqlConnection cnn = new SqlConnection(connect);
                    cnn.Open();
                    string stmt = "insert into Pacienti ([CNP], [Nume], [Prenume], [Sex], [Nume_mama],[Nume_tata], [Data_nasterii], [Locul_nasterii], [APGAR], [Medic_familie], [Antecedente]) values(@cnp, @n, @p, @s, @nm, @nt, @dn, @ln, @apgar, @mf, @a)";
                    SqlCommand sc = new SqlCommand(stmt, cnn);
                    sc.Parameters.AddWithValue("@cnp", txtCNP.Text);
                    sc.Parameters.AddWithValue("@n", txtNume.Text);
                    sc.Parameters.AddWithValue("@p", txtPrenume.Text);
                    sc.Parameters.AddWithValue("@s", comboBox1.SelectedItem.ToString());
                    sc.Parameters.AddWithValue("@nm", txtNumeM.Text);
                    sc.Parameters.AddWithValue("@nt", txtNumeT.Text);
                    sc.Parameters.AddWithValue("@dn", dateTimePicker1.Value);
                    sc.Parameters.AddWithValue("@ln", txtLoc.Text);
                    sc.Parameters.AddWithValue("@apgar", txtAPGAR.Text);
                    sc.Parameters.AddWithValue("@mf", txtMedic.Text);
                    sc.Parameters.AddWithValue("@a", txtAntecedente.Text);
                    sc.ExecuteNonQuery();
                    cnn.Close();
                    this.DialogResult = DialogResult.OK;
                    this.Close();
                }
                else
                {
                    MessageBox.Show("CNP-ul introdus exista deja!","Eroare",MessageBoxButtons.OK,MessageBoxIcon.Error);
                    txtCNP.Text = "";
                }
                    
            }
            else
                MessageBox.Show("Nu ati introdus CNP!");
        }

        private void txtCNP_Leave(object sender, EventArgs e)
        {
            if (!checkCNP(txtCNP.Text))
            {
                MessageBox.Show("CNP gresit!");
                txtCNP.Text = "";
            }
            else
            {
                string cnp = txtCNP.Text;
                string aux="19";
                switch (cnp[0])
                {
                    case '3':
                    case '4':
                        aux = "18";
                        break;
                    case '5':
                    case '6':
                        aux = "20";
                        break;
                }
                string date = cnp[3] + "" + cnp[4] + "/" + cnp[5] + cnp[6] + "/" + aux + cnp[1] + cnp[2];
                dateTimePicker1.Value = DateTime.ParseExact(date, "d", CultureInfo.InvariantCulture);
                TimeSpan t = DateTime.Now.Subtract(dateTimePicker1.Value);
                int varsta = (int)(t.TotalDays)/365;
                txtVarsta.Text = varsta.ToString();
            }

        }
    }
}
