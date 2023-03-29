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

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        string[] parole;

        public Form1()
        {
            InitializeComponent();
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            string[] fisier = File.ReadAllLines("utilizatori.txt");
            string[] utilizatori = new string[fisier.Length];
            parole = new string[fisier.Length];
            for(int i=0; i<fisier.Length; i++)
            {
                string[] temp = fisier[i].Split(' ');
                utilizatori[i] = temp[0];
                parole[i] = temp[1];
            }
            for(int i =0;i< utilizatori.Length; i++) 
                comboBox1.Items.Add(utilizatori[i]);
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            int index = comboBox1.SelectedIndex;
            if (index == -1)
                MessageBox.Show("Alegeti un utilizator!");
            else
            {
                if (textBox1.Text.Equals(parole[index]))
                {
                    Form2 f = new Form2();
                    f.ShowDialog();
                }
                else
                {
                    MessageBox.Show("Eroare logare", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    textBox1.Text = " ";
                }
            }
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            Environment.Exit(0);
        }
    }
}
