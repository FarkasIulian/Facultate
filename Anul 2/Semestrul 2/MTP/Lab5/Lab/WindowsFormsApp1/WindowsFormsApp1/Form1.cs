using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnGo_Click(object sender, EventArgs e)
        {
            int n, m;
            n = int.Parse(txtn.Text);
            m = int.Parse(txtm.Text);
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    if ( (i == 0 || i == n - 1) || (j == 0 || j == m-1))
                    {
                        Button b = new Button();
                        b.Width = 100;
                        b.Location = new System.Drawing.Point(i * 100 + 100, j * 25 + 50);
                        this.Controls.Add(b);
                    }             
                }
            }
        }
    }
}
