namespace Salary_Package
{
    partial class Main
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
            this.label1 = new System.Windows.Forms.Label();
            this.emplyID = new System.Windows.Forms.TextBox();
            this.emplyfname = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.emplylname = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.btnsave = new System.Windows.Forms.Button();
            this.btndelete = new System.Windows.Forms.Button();
            this.table = new System.Windows.Forms.DataGridView();
            this.btnreset = new System.Windows.Forms.Button();
            this.btnretrive = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.txtsearch = new System.Windows.Forms.TextBox();
            this.comboBox1 = new System.Windows.Forms.ComboBox();
            this.searchtable = new System.Windows.Forms.DataGridView();
            this.btnfulldisplay = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.table)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.searchtable)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(32, 58);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(115, 20);
            this.label1.TabIndex = 0;
            this.label1.Text = "Employee ID";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // emplyID
            // 
            this.emplyID.Location = new System.Drawing.Point(253, 58);
            this.emplyID.Name = "emplyID";
            this.emplyID.Size = new System.Drawing.Size(162, 22);
            this.emplyID.TabIndex = 1;
            // 
            // emplyfname
            // 
            this.emplyfname.Location = new System.Drawing.Point(253, 102);
            this.emplyfname.Name = "emplyfname";
            this.emplyfname.Size = new System.Drawing.Size(162, 22);
            this.emplyfname.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(32, 104);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(189, 20);
            this.label2.TabIndex = 2;
            this.label2.Text = "Employee First Name";
            // 
            // emplylname
            // 
            this.emplylname.Location = new System.Drawing.Point(253, 156);
            this.emplylname.Name = "emplylname";
            this.emplylname.Size = new System.Drawing.Size(162, 22);
            this.emplylname.TabIndex = 5;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(32, 158);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(187, 20);
            this.label3.TabIndex = 4;
            this.label3.Text = "Employee Last Name";
            // 
            // btnsave
            // 
            this.btnsave.BackColor = System.Drawing.Color.Lime;
            this.btnsave.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnsave.Location = new System.Drawing.Point(36, 280);
            this.btnsave.Name = "btnsave";
            this.btnsave.Size = new System.Drawing.Size(94, 32);
            this.btnsave.TabIndex = 6;
            this.btnsave.Text = "Save";
            this.btnsave.UseVisualStyleBackColor = false;
            this.btnsave.Click += new System.EventHandler(this.btnsave_Click);
            // 
            // btndelete
            // 
            this.btndelete.BackColor = System.Drawing.Color.Red;
            this.btndelete.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btndelete.Location = new System.Drawing.Point(36, 363);
            this.btndelete.Name = "btndelete";
            this.btndelete.Size = new System.Drawing.Size(94, 32);
            this.btndelete.TabIndex = 7;
            this.btndelete.Text = "Delete";
            this.btndelete.UseVisualStyleBackColor = false;
            this.btndelete.Click += new System.EventHandler(this.btndelete_Click);
            // 
            // table
            // 
            this.table.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.table.Location = new System.Drawing.Point(576, 30);
            this.table.Name = "table";
            this.table.RowHeadersWidth = 51;
            this.table.RowTemplate.Height = 24;
            this.table.Size = new System.Drawing.Size(551, 468);
            this.table.TabIndex = 8;
            // 
            // btnreset
            // 
            this.btnreset.BackColor = System.Drawing.Color.Yellow;
            this.btnreset.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnreset.Location = new System.Drawing.Point(208, 280);
            this.btnreset.Name = "btnreset";
            this.btnreset.Size = new System.Drawing.Size(107, 32);
            this.btnreset.TabIndex = 9;
            this.btnreset.Text = "Update";
            this.btnreset.UseVisualStyleBackColor = false;
            this.btnreset.Click += new System.EventHandler(this.btnreset_Click);
            // 
            // btnretrive
            // 
            this.btnretrive.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(128)))));
            this.btnretrive.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnretrive.Location = new System.Drawing.Point(208, 363);
            this.btnretrive.Name = "btnretrive";
            this.btnretrive.Size = new System.Drawing.Size(107, 32);
            this.btnretrive.TabIndex = 10;
            this.btnretrive.Text = "Retrive";
            this.btnretrive.UseVisualStyleBackColor = false;
            this.btnretrive.Click += new System.EventHandler(this.btnretrive_Click);
            // 
            // button1
            // 
            this.button1.BackColor = System.Drawing.Color.Magenta;
            this.button1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button1.Location = new System.Drawing.Point(12, 470);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(107, 32);
            this.button1.TabIndex = 11;
            this.button1.Text = "Search";
            this.button1.UseVisualStyleBackColor = false;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // txtsearch
            // 
            this.txtsearch.Location = new System.Drawing.Point(345, 470);
            this.txtsearch.Multiline = true;
            this.txtsearch.Name = "txtsearch";
            this.txtsearch.Size = new System.Drawing.Size(162, 32);
            this.txtsearch.TabIndex = 13;
            // 
            // comboBox1
            // 
            this.comboBox1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.comboBox1.FormattingEnabled = true;
            this.comboBox1.Items.AddRange(new object[] {
            "Employee ID",
            "First Name",
            "Last Name"});
            this.comboBox1.Location = new System.Drawing.Point(148, 469);
            this.comboBox1.Name = "comboBox1";
            this.comboBox1.Size = new System.Drawing.Size(175, 33);
            this.comboBox1.TabIndex = 14;
            // 
            // searchtable
            // 
            this.searchtable.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.searchtable.Location = new System.Drawing.Point(18, 525);
            this.searchtable.Name = "searchtable";
            this.searchtable.RowHeadersWidth = 51;
            this.searchtable.RowTemplate.Height = 24;
            this.searchtable.Size = new System.Drawing.Size(561, 91);
            this.searchtable.TabIndex = 16;
            // 
            // btnfulldisplay
            // 
            this.btnfulldisplay.BackColor = System.Drawing.Color.Yellow;
            this.btnfulldisplay.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnfulldisplay.Location = new System.Drawing.Point(114, 213);
            this.btnfulldisplay.Name = "btnfulldisplay";
            this.btnfulldisplay.Size = new System.Drawing.Size(169, 32);
            this.btnfulldisplay.TabIndex = 17;
            this.btnfulldisplay.Text = "Full Display";
            this.btnfulldisplay.UseVisualStyleBackColor = false;
            this.btnfulldisplay.Click += new System.EventHandler(this.btnfulldisplay_Click);
            // 
            // Main
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.MenuHighlight;
            this.ClientSize = new System.Drawing.Size(1159, 641);
            this.Controls.Add(this.btnfulldisplay);
            this.Controls.Add(this.searchtable);
            this.Controls.Add(this.comboBox1);
            this.Controls.Add(this.txtsearch);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.btnretrive);
            this.Controls.Add(this.btnreset);
            this.Controls.Add(this.table);
            this.Controls.Add(this.btndelete);
            this.Controls.Add(this.btnsave);
            this.Controls.Add(this.emplylname);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.emplyfname);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.emplyID);
            this.Controls.Add(this.label1);
            this.Name = "Main";
            this.Text = "Main";
            this.Load += new System.EventHandler(this.Main_Load);
            ((System.ComponentModel.ISupportInitialize)(this.table)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.searchtable)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox emplyID;
        private System.Windows.Forms.TextBox emplyfname;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox emplylname;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button btnsave;
        private System.Windows.Forms.Button btndelete;
        private System.Windows.Forms.DataGridView table;
        private System.Windows.Forms.Button btnreset;
        private System.Windows.Forms.Button btnretrive;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.TextBox txtsearch;
        private System.Windows.Forms.ComboBox comboBox1;
        private System.Windows.Forms.DataGridView searchtable;
        private System.Windows.Forms.Button btnfulldisplay;
    }
}
