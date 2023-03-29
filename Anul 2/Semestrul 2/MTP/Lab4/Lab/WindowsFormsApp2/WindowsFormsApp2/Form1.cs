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

namespace WindowsFormsApp2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            StreamReader fin = new StreamReader("C:\\Facultate\\MTP\\Lab4\\WindowsFormsApp2\\WindowsFormsApp2\\login.txt");
            String line = "";
            while (!fin.EndOfStream)
                line += fin.ReadLine()+" ";
            line=line.Trim();
            String[] date = line.Split(' ');
            for (int i = 0; i < date.Length; i = i + 2)
                comboBox1.Items.Add(date[i]);

        }
    }
}
