namespace WindowsFormsApp1
{
    partial class Form2
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
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.label1 = new System.Windows.Forms.Label();
            this.txtCautat = new System.Windows.Forms.TextBox();
            this.btnCauta = new System.Windows.Forms.Button();
            this.btnAddPacient = new System.Windows.Forms.Button();
            this.btnViewPacients = new System.Windows.Forms.Button();
            this.btnAddConsult = new System.Windows.Forms.Button();
            this.btnClose = new System.Windows.Forms.Button();
            this.btnAddRadio = new System.Windows.Forms.Button();
            this.btnRefresh = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(91, 100);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowHeadersWidth = 51;
            this.dataGridView1.RowTemplate.Height = 24;
            this.dataGridView1.Size = new System.Drawing.Size(790, 348);
            this.dataGridView1.TabIndex = 0;
            this.dataGridView1.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellContentClick);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(197, 51);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(88, 16);
            this.label1.TabIndex = 1;
            this.label1.Text = "Nume cautat: ";
            // 
            // txtCautat
            // 
            this.txtCautat.Location = new System.Drawing.Point(292, 51);
            this.txtCautat.Name = "txtCautat";
            this.txtCautat.Size = new System.Drawing.Size(340, 22);
            this.txtCautat.TabIndex = 2;
            // 
            // btnCauta
            // 
            this.btnCauta.Location = new System.Drawing.Point(672, 41);
            this.btnCauta.Name = "btnCauta";
            this.btnCauta.Size = new System.Drawing.Size(120, 43);
            this.btnCauta.TabIndex = 3;
            this.btnCauta.Text = "Cautare";
            this.btnCauta.UseVisualStyleBackColor = true;
            this.btnCauta.Click += new System.EventHandler(this.btnCauta_Click);
            // 
            // btnAddPacient
            // 
            this.btnAddPacient.Location = new System.Drawing.Point(179, 487);
            this.btnAddPacient.Name = "btnAddPacient";
            this.btnAddPacient.Size = new System.Drawing.Size(160, 65);
            this.btnAddPacient.TabIndex = 4;
            this.btnAddPacient.Text = "Adaugare pacient";
            this.btnAddPacient.UseVisualStyleBackColor = true;
            this.btnAddPacient.Click += new System.EventHandler(this.btnAddPacient_Click);
            // 
            // btnViewPacients
            // 
            this.btnViewPacients.Location = new System.Drawing.Point(179, 568);
            this.btnViewPacients.Name = "btnViewPacients";
            this.btnViewPacients.Size = new System.Drawing.Size(160, 65);
            this.btnViewPacients.TabIndex = 5;
            this.btnViewPacients.Text = "Vizualizare pacienti";
            this.btnViewPacients.UseVisualStyleBackColor = true;
            this.btnViewPacients.Click += new System.EventHandler(this.btnViewPacients_Click);
            // 
            // btnAddConsult
            // 
            this.btnAddConsult.Location = new System.Drawing.Point(404, 487);
            this.btnAddConsult.Name = "btnAddConsult";
            this.btnAddConsult.Size = new System.Drawing.Size(160, 65);
            this.btnAddConsult.TabIndex = 6;
            this.btnAddConsult.Text = "Adaugare consultatie";
            this.btnAddConsult.UseVisualStyleBackColor = true;
            this.btnAddConsult.Click += new System.EventHandler(this.btnAddConsult_Click);
            // 
            // btnClose
            // 
            this.btnClose.Location = new System.Drawing.Point(404, 568);
            this.btnClose.Name = "btnClose";
            this.btnClose.Size = new System.Drawing.Size(160, 65);
            this.btnClose.TabIndex = 7;
            this.btnClose.Text = "Inchidere aplicatie";
            this.btnClose.UseVisualStyleBackColor = true;
            this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
            // 
            // btnAddRadio
            // 
            this.btnAddRadio.Location = new System.Drawing.Point(612, 487);
            this.btnAddRadio.Name = "btnAddRadio";
            this.btnAddRadio.Size = new System.Drawing.Size(160, 65);
            this.btnAddRadio.TabIndex = 8;
            this.btnAddRadio.Text = "Adaugare radiografie";
            this.btnAddRadio.UseVisualStyleBackColor = true;
            this.btnAddRadio.Click += new System.EventHandler(this.btnAddRadio_Click);
            // 
            // btnRefresh
            // 
            this.btnRefresh.Location = new System.Drawing.Point(612, 568);
            this.btnRefresh.Name = "btnRefresh";
            this.btnRefresh.Size = new System.Drawing.Size(160, 65);
            this.btnRefresh.TabIndex = 9;
            this.btnRefresh.Text = "Refresh";
            this.btnRefresh.UseVisualStyleBackColor = true;
            this.btnRefresh.Click += new System.EventHandler(this.btnRefresh_Click);
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(972, 660);
            this.Controls.Add(this.btnRefresh);
            this.Controls.Add(this.btnAddRadio);
            this.Controls.Add(this.btnClose);
            this.Controls.Add(this.btnAddConsult);
            this.Controls.Add(this.btnViewPacients);
            this.Controls.Add(this.btnAddPacient);
            this.Controls.Add(this.btnCauta);
            this.Controls.Add(this.txtCautat);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.dataGridView1);
            this.Name = "Form2";
            this.Text = "Form2";
            this.Load += new System.EventHandler(this.Form2_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtCautat;
        private System.Windows.Forms.Button btnCauta;
        private System.Windows.Forms.Button btnAddPacient;
        private System.Windows.Forms.Button btnViewPacients;
        private System.Windows.Forms.Button btnAddConsult;
        private System.Windows.Forms.Button btnClose;
        private System.Windows.Forms.Button btnAddRadio;
        private System.Windows.Forms.Button btnRefresh;
    }
}