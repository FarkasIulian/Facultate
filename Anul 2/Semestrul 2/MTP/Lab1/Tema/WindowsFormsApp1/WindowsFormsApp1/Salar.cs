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
    public partial class Salar : Form
    {
        public Salar()
        {
            InitializeComponent();
        }
        private void Salar_Load(object sender, EventArgs e)
        {
            label7.Text = "";
            label8.Text = "";
            label9.Text = "";
            label10.Text = "";
            lblCAS.Text ="";
            lblCFS.Text = "";
            lblCFCI.Text = "";
            lblCFGPCS.Text = "";
            lblCASS.Text = "";
            lblCFAMBP.Text = "";
        }

        public string smallNumbers(int n)
        {
            switch (n)
            {
                case 0: return "Zero";
                case 1: return "Unu";
                case 2: return "Doua";
                case 3: return "Trei";
                case 4: return "Patru";
                case 5: return "Cinci";
                case 6: return "Sase";
                case 7: return "Sapte";
                case 8: return "Opt";
                case 9: return "Noua";
                default: return "Zece";
            }
        }

        public string oneDigit(int n)
        {
            string final;
            final = smallNumbers(n);
            return final;
        }

        public string twoDigits(int n)
        {
            string final;
            if (n >= 10 && n<20)
            {
                if (n == 10)
                    return oneDigit(10);
                final = oneDigit(n % 10) + "sprezece";
                return final;
            }
            else
            {
                final = oneDigit(n / 10) + " zeci";
                if (n % 10 == 0)
                    return final;
                final += " si " + oneDigit(n % 10).ToLower();
            }
            return final;
        }

        public string threeDigits(int n)
        {
            string final;
            string aux;
            if (n / 100 == 1)
                final = "O suta";
            else
                final = oneDigit(n / 100) + " sute";
            if (n % 100 == 0)
                return final;
            aux=n.ToString().Remove(0, 1);
            if(int.TryParse(aux,out n))
            {
                if (n < 10)
                    return final +" " + oneDigit(n).ToLower();
                else
                    return final + " " + twoDigits(n).ToLower();
 
            }
            return "";
        }

        public string fourDigits(int n)
        {
            string final;
            string aux;
            if (n / 1000 == 1)
                final = "O mie";
            else
                final = oneDigit(n / 1000) + " mii";
            if (n % 1000 == 0) 
            {
                return final;
            }
            aux=n.ToString().Remove(0, 1);
            if (int.TryParse(aux,out n))
            {
                if (n < 100)
                    return final + " " + twoDigits(n).ToLower();
                else
                    return final + " " + threeDigits(n).ToLower();
            }
            return "";
        }

        public string generateWords(int n)
        {
            int digits=0;
            int numar = n;
            while (numar > 0)
            {
                numar = numar / 10;
                digits++;
            }
            if(digits == 1 || n == 0)
                return oneDigit(n);
            if(digits == 2)
                    return twoDigits(n);
            if(digits == 3)
                return threeDigits(n);
            if(digits == 4)
                return fourDigits(n);            
            if(digits == 5)
            {
                string firstTwoDigits = n.ToString().Remove(2, 3);
                string lastThreeDigits = n.ToString().Remove(0,2);
                int x, y;
                if(int.TryParse(firstTwoDigits,out x) && int.TryParse(lastThreeDigits,out y))
                {
                    if(x < 20)
                        return twoDigits(x) + " mii " + threeDigits(y).ToLower();
                    else
                        return twoDigits(x) + " de mii " + threeDigits(y).ToLower();
                }
            }
            if(digits == 6)
            {
                string firstThreeDigits = n.ToString().Remove(3, 3);
                string lastThreeDigits = n.ToString().Remove(0, 3);
                int x, y;
                if (int.TryParse(firstThreeDigits, out x) && int.TryParse(lastThreeDigits, out y))
                {
                        return threeDigits(x) + " de mii " + threeDigits(y).ToLower();
                }
            }
            return "Salariu prea mare!";
        }
        
        private void button1_Click(object sender, EventArgs e)
        {
            double salar;
            if(double.TryParse(txtSalar.Text,out salar))
            {
                double CFS_angajat, CAS_angajat, CASS_angajat,imp_angajat;
                double CAS_angajator, CFS, CFCI, CFPGPCS, CASS_angajator, CFAMBP;
                CFS_angajat = (salar / 1000) * 5;
                CAS_angajat = (salar / 1000) * 105;
                CASS_angajat = (salar / 1000) * 55;
                imp_angajat = ((salar - CFS_angajat - CAS_angajat - CASS_angajat - 180) / 1000) * 160;
                CAS_angajator = (salar / 1000) * 208;
                CFS = (salar / 1000) * 50;
                CFCI = (salar / 1000) * 85;
                CFPGPCS = (salar / 10000) * 25;
                CASS_angajator = (salar / 1000) * 52;
                CFAMBP = (salar / 1000) * 4;
                label7.Text = CFS_angajat.ToString();
                label8.Text = CAS_angajat.ToString();
                label9.Text = CASS_angajat.ToString();
                label10.Text = imp_angajat.ToString();
                lblCAS.Text = (CAS_angajator).ToString();
                lblCFS.Text = (CFS).ToString();
                lblCFCI.Text = (CFCI).ToString();
                lblCFGPCS.Text = (CFPGPCS).ToString();
                lblCASS.Text = (CASS_angajator).ToString();
                lblCFAMBP.Text = (CFAMBP).ToString();
                MessageBox.Show(generateWords((int)salar),"Salariu in cuvinte",MessageBoxButtons.OK,MessageBoxIcon.Information);
            }
            else
            {
                MessageBox.Show("Salariu invalid!","Eroare salariu",MessageBoxButtons.OK,MessageBoxIcon.Error);
                txtSalar.Focus();
                if(txtSalar.Text.Length != 0)
                txtSalar.Text = txtSalar.Text.Remove(0);
                return;
            }

        }

    }
}
