package smartpcb.forms;

import java.awt.Image;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
import SaveObjects.Project;
import javax.swing.JMenuItem;
import smartpcb.Main;
import smartpcb.PropertiesManager;
import smartpcb.WindowManager;

public class MainFrame extends javax.swing.JFrame
{
    public MainFrame() 
    {
        initComponents();
        setLocationRelativeTo(null);
        imagePanel.setImage((Image) Main.mainFrameResources.getResource("back_image"));
        tabbedPane.setVisible(false);
        WindowManager.setComponents(tabbedPane, projectTree1,this);
        JMenuItem item1 = new JMenuItem("Close");
        tabbedPanePopup.add(item1);
        jPanel1.remove(jScrollPane1);
    }
    public void setTabVisible(boolean visible)
    {
        tabbedPane.setVisible(visible);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openProjectFileChooser = new javax.swing.JFileChooser();
        tabbedPanePopup = new javax.swing.JPopupMenu();
        ToolBar = new javax.swing.JToolBar();
        btnGrid = new javax.swing.JButton();
        imagePanel = new Components.Panels.ImagePanel();
        tabbedPane = new Components.TabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        projectTree1 = new Components.ProjectTree();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        NewProjectMenuItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        openProjectMenuItem = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        btnExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        AboutMenuItem = new javax.swing.JMenuItem();

        openProjectFileChooser.setAcceptAllFileFilterUsed(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SmartPcb");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        ToolBar.setFloatable(false);
        ToolBar.setRollover(true);

        btnGrid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/grid.png"))); // NOI18N
        btnGrid.setFocusable(false);
        btnGrid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGrid.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGridActionPerformed(evt);
            }
        });
        ToolBar.add(btnGrid);

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        projectTree1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Project Browser", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));
        projectTree1.setPreferredSize(new java.awt.Dimension(60, 0));
        jScrollPane2.setViewportView(projectTree1);

        jPanel1.add(jScrollPane2);

        jTree1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parts Browser", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));
        jScrollPane1.setViewportView(jTree1);

        jPanel1.add(jScrollPane1);

        jMenu1.setText("File");

        NewProjectMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/new project.png"))); // NOI18N
        NewProjectMenuItem.setText("New Project");
        NewProjectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewProjectMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(NewProjectMenuItem);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/new file.png"))); // NOI18N
        jMenuItem2.setText("New File");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator1);

        openProjectMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/open project.png"))); // NOI18N
        openProjectMenuItem.setText("Open Project");
        openProjectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openProjectMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(openProjectMenuItem);

        jMenuItem4.setText("Open Recent Project");
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Close Project");
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator2);

        jMenuItem6.setText("Save");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);
        jMenu1.add(jSeparator3);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jMenu1.add(btnExit);

        MenuBar.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem8.setText("Undo");
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("Redo");
        jMenu2.add(jMenuItem9);
        jMenu2.add(jSeparator4);

        jMenuItem10.setText("Cut");
        jMenu2.add(jMenuItem10);

        jMenuItem11.setText("Copy");
        jMenu2.add(jMenuItem11);

        jMenuItem12.setText("Paste");
        jMenu2.add(jMenuItem12);

        jMenuItem13.setText("Delete");
        jMenu2.add(jMenuItem13);

        MenuBar.add(jMenu2);

        jMenu3.setText("View");
        MenuBar.add(jMenu3);

        jMenu7.setText("Library");

        jMenuItem1.setText("Select Libraries");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem1);
        jMenu7.add(jSeparator5);

        jMenuItem3.setText("Create Part");
        jMenu7.add(jMenuItem3);

        MenuBar.add(jMenu7);

        jMenu4.setText("Tools");

        jMenuItem14.setText("Options");
        jMenu4.add(jMenuItem14);

        MenuBar.add(jMenu4);

        jMenu5.setText("Window");
        MenuBar.add(jMenu5);

        jMenu6.setText("Help");

        AboutMenuItem.setText("About");
        AboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutMenuItemActionPerformed(evt);
            }
        });
        jMenu6.add(AboutMenuItem);

        MenuBar.add(jMenu6);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void NewProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewProjectMenuItemActionPerformed
        (new NewProjectDialog(this)).setVisible(true);
    }//GEN-LAST:event_NewProjectMenuItemActionPerformed

    private void AboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutMenuItemActionPerformed
        (new AboutDialog(this)).setVisible(true);
    }//GEN-LAST:event_AboutMenuItemActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void openProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openProjectMenuItemActionPerformed
        openProjectFileChooser.setCurrentDirectory(new File(PropertiesManager.get("project_path")));
        openProjectFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("SmartPcb Project Files",PropertiesManager.get("project_ext")));
        openProjectFileChooser.showOpenDialog(this);
        if(openProjectFileChooser.getSelectedFile()!=null)
        {
            Project project = Project.load(openProjectFileChooser.getSelectedFile());
            WindowManager.openProject(project);
        }
        
    }//GEN-LAST:event_openProjectMenuItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        PropertiesManager.saveProperties();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        (new LibraryManagerDialog(this)).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        jPanel1.add(jScrollPane1);
        jPanel1.validate();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btnGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGridActionPerformed
        (new GridDialog(this)).setVisible(true);
    }//GEN-LAST:event_btnGridActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutMenuItem;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem NewProjectMenuItem;
    private javax.swing.JToolBar ToolBar;
    private javax.swing.JMenuItem btnExit;
    private javax.swing.JButton btnGrid;
    private Components.Panels.ImagePanel imagePanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JTree jTree1;
    private javax.swing.JFileChooser openProjectFileChooser;
    private javax.swing.JMenuItem openProjectMenuItem;
    public Components.ProjectTree projectTree1;
    private Components.TabbedPane tabbedPane;
    private javax.swing.JPopupMenu tabbedPanePopup;
    // End of variables declaration//GEN-END:variables

}
