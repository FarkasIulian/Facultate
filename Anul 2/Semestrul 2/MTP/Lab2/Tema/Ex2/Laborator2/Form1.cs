using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Laborator2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnFis_Click(object sender, EventArgs e)
        {
            String fisier1=null,fisier2=null,fisier3;
            if (!File.Exists("unu.txt"))
            {
                MessageBox.Show("EROARE FISIER UNU.TXT", "EROARE", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            StreamReader f1 = new StreamReader("unu.txt");
            fisier1 = f1.ReadToEnd();
            f1.Close();
            
            if (!File.Exists("doi.txt"))
            {
                MessageBox.Show("EROARE FISIER DOI.TXT", "EROARE", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            StreamReader f2 = new StreamReader("doi.txt");
            fisier2 = f2.ReadToEnd();
            f2.Close();
            
            fisier3 = fisier1 + fisier2;
            StreamWriter write = new StreamWriter("trei.txt");
            write.WriteLine(fisier3);
            write.Close();
            MessageBox.Show("Concatenarea a fost realizata","INFO",MessageBoxButtons.OK,MessageBoxIcon.Information);

        }
    }
}
