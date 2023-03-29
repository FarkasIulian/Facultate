namespace WindowsFormsApp1
{
    partial class Adaugare_consultatie
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.txtCNP = new System.Windows.Forms.TextBox();
            this.txtDiag = new System.Windows.Forms.TextBox();
            this.txtSimpt = new System.Windows.Forms.TextBox();
            this.txtTrat = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.dateTimePicker1 = new System.Windows.Forms.DateTimePicker();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.btnAddConsult = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // txtCNP
            // 
            this.txtCNP.Location = new System.Drawing.Point(161, 68);
            this.txtCNP.Name = "txtCNP";
            this.txtCNP.Size = new System.Drawing.Size(189, 22);
            this.txtCNP.TabIndex = 0;
            // 
            // txtDiag
            // 
            this.txtDiag.Location = new System.Drawing.Point(161, 282);
            this.txtDiag.Name = "txtDiag";
            this.txtDiag.Size = new System.Drawing.Size(189, 22);
            this.txtDiag.TabIndex = 3;
            // 
            // txtSimpt
            // 
            this.txtSimpt.Location = new System.Drawing.Point(161, 210);
            this.txtSimpt.Name = "txtSimpt";
            this.txtSimpt.Size = new System.Drawing.Size(189, 22);
            this.txtSimpt.TabIndex = 2;
            // 
            // txtTrat
            // 
            this.txtTrat.Location = new System.Drawing.Point(161, 347);
            this.txtTrat.Name = "txtTrat";
            this.txtTrat.Size = new System.Drawing.Size(189, 22);
            this.txtTrat.TabIndex = 4;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(66, 71);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(82, 16);
            this.label1.TabIndex = 5;
            this.label1.Text = "CNP pacient";
            // 
            // dateTimePicker1
            // 
            this.dateTimePicker1.Location = new System.Drawing.Point(161, 140);
            this.dateTimePicker1.Name = "dateTimePicker1";
            this.dateTimePicker1.Size = new System.Drawing.Size(200, 22);
            this.dateTimePicker1.TabIndex = 6;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(93, 143);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(36, 16);
            this.label2.TabIndex = 7;
            this.label2.Text = "Data";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(85, 213);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(68, 16);
            this.label3.TabIndex = 8;
            this.label3.Text = "Simptome";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(82, 285);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(71, 16);
            this.label4.TabIndex = 9;
            this.label4.Text = "Diagnostic";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(83, 350);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(68, 16);
            this.label5.TabIndex = 10;
            this.label5.Text = "Tratament";
            // 
            // btnAddConsult
            // 
            this.btnAddConsult.Location = new System.Drawing.Point(161, 432);
            this.btnAddConsult.Name = "btnAddConsult";
            this.btnAddConsult.Size = new System.Drawing.Size(169, 46);
            this.btnAddConsult.TabIndex = 11;
            this.btnAddConsult.Text = "Adauga consultatie";
            this.btnAddConsult.UseVisualStyleBackColor = true;
            this.btnAddConsult.Click += new System.EventHandler(this.btnAddConsult_Click);
            // 
            // Adaugare_consultatie
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(494, 521);
            this.Controls.Add(this.btnAddConsult);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.dateTimePicker1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtTrat);
            this.Controls.Add(this.txtDiag);
            this.Controls.Add(this.txtSimpt);
            this.Controls.Add(this.txtCNP);
            this.Name = "Adaugare_consultatie";
            this.Text = "Adaugare_consultatie";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtCNP;
        private System.Windows.Forms.TextBox txtDiag;
        private System.Windows.Forms.TextBox txtSimpt;
        private System.Windows.Forms.TextBox txtTrat;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.DateTimePicker dateTimePicker1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Button btnAddConsult;
    }
}