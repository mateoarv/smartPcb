package smartpcb.forms;

import SaveObjects.Circuit;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import SaveObjects.Project;
import smartpcb.Dialog;
import smartpcb.Main;
import smartpcb.PropertiesManager;
import smartpcb.WindowManager;

public class NewProjectDialog extends javax.swing.JDialog {
    
    public NewProjectDialog(java.awt.Frame parent)
    {
        super(parent, true);
        initComponents();
        this.setSize(this.getPreferredSize());
        this.setLocationRelativeTo(null);
        ProjectFileChooser.setSelectedFile(new File(PropertiesManager.get("project_path")));
        txtProjectFolder.setText(ProjectFileChooser.getSelectedFile().getAbsolutePath());
        checkInfoComplete();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProjectFileChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtProjectName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtProjectFolder = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnCancel = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();
        lblProjectPath = new javax.swing.JLabel();

        ProjectFileChooser.setAcceptAllFileFilterUsed(false);
        ProjectFileChooser.setDialogType(javax.swing.JFileChooser.CUSTOM_DIALOG);
        ProjectFileChooser.setApproveButtonText("Select");
        ProjectFileChooser.setCurrentDirectory(null);
        ProjectFileChooser.setDialogTitle("");
        ProjectFileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/new project.png"))); // NOI18N
        jLabel1.setText("New Project");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setLabelFor(txtProjectName);
        jLabel2.setText("Project Name:");

        txtProjectName.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtProjectNameCaretUpdate(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setLabelFor(txtProjectFolder);
        jLabel3.setText("Project Folder:");

        txtProjectFolder.setEditable(false);

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnFinish.setText("Finish");
        btnFinish.setEnabled(false);
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });

        lblProjectPath.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProjectPath.setLabelFor(txtProjectFolder);
        lblProjectPath.setText("Project Path:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFinish)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addGap(7, 7, 7))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProjectName))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProjectFolder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBrowse))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProjectPath))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProjectFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProjectPath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinish)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        ProjectFileChooser.setCurrentDirectory(new File(PropertiesManager.get("project_path"))); //FIXME
        ProjectFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("SmartPcb Project Files",PropertiesManager.get("project_ext")));
        ProjectFileChooser.showDialog(this, "Select");
        if(ProjectFileChooser.getSelectedFile()!=null)
            txtProjectFolder.setText(ProjectFileChooser.getSelectedFile().getAbsolutePath());
        else
            txtProjectFolder.setText("");
        checkInfoComplete();
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void txtProjectNameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtProjectNameCaretUpdate
        checkInfoComplete();
    }//GEN-LAST:event_txtProjectNameCaretUpdate

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        File file = new File(ProjectFileChooser.getSelectedFile().getAbsolutePath() + PropertiesManager.get("separator") + txtProjectName.getText() + "." + PropertiesManager.get("project_ext"));
        if(!file.exists() || Dialog.showQuestion(this, "The file \"" + file.getName() + "\" already exists. Do you wish to replace it?", "Replace File") )
        {
            Project project = new Project(file,txtProjectName.getText());
            
            /*
            Circuit c1,c2;
            c1 = new Circuit("Circuito1");
            c2 = new Circuit("Circuito2");
            c1.createBoard();
            c1.createBoard();
            c2.createBoard();
            project.addCircuit(c1);
            project.addCircuit(c2);
            */
            
            project.save();
            WindowManager.openProject(project);
            this.dispose();
        }
        
    }//GEN-LAST:event_btnFinishActionPerformed
    private void checkInfoComplete()
    {
        btnFinish.setEnabled(!txtProjectName.getText().equals("") && ProjectFileChooser.getSelectedFile()!=null);
        if(ProjectFileChooser.getSelectedFile()!=null)
            lblProjectPath.setText("Project Path: " + ProjectFileChooser.getSelectedFile().getAbsolutePath() + PropertiesManager.get("separator") + txtProjectName.getText() + "." + PropertiesManager.get("project_ext"));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser ProjectFileChooser;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFinish;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblProjectPath;
    private javax.swing.JTextField txtProjectFolder;
    private javax.swing.JTextField txtProjectName;
    // End of variables declaration//GEN-END:variables
}
