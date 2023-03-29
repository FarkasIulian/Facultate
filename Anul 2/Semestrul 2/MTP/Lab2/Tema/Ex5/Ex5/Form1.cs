using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ex5
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnGenerate_Click(object sender, EventArgs e)
        {
            if (txtX.Text == "" || txtY.Text == "" || txtNume.Text == "")
            {
                MessageBox.Show("COMPLETATI TOATE CASETELE!", "EROARE", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            int x, y;
            if(!int.TryParse(txtX.Text,out x))
            {
                MessageBox.Show("X TREBUIE SA FIE UN NUMAR!","EROARE",MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            if (!int.TryParse(txtY.Text, out y))
            {
                MessageBox.Show("Y TREBUIE SA FIE UN NUMAR!", "EROARE", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            Label lbl = new Label();
            lbl.Text = txtNume.Text;
            lbl.Location = new Point(x,y);
            Controls.Add(lbl);
        }
    }
}
