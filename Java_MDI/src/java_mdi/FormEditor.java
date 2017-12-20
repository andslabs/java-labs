package java_mdi;

import java.io.*;
import java.util.regex.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.event.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.*;

public class FormEditor extends javax.swing.JInternalFrame {

    private boolean isOpened = false;
    private boolean isModified = false;
    private static FormEditor instance;
    public static int counter = 0;
    private File openedFile;

    /**
     * Creates new form FormEditor
     */
    private FormEditor() {
        initComponents();
        textMain.setLineWrap(true);
        textMain.setWrapStyleWord(true);
        
    }
    
    public static FormEditor getInstance(){
        if (counter <= 5) {
            instance = new FormEditor();
            return instance;
        } else return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        textMain = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        mntmFile_1 = new javax.swing.JMenu();
        mntmOpen = new javax.swing.JMenuItem();
        mntmSave = new javax.swing.JMenuItem();
        mntmSaveAs = new javax.swing.JMenuItem();
        mntmInfo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mntmExit = new javax.swing.JMenuItem();
        mntmFind = new javax.swing.JMenu();
        nameSurname = new javax.swing.JMenuItem();
        surnameInitials = new javax.swing.JMenuItem();
        javaKeywords = new javax.swing.JMenuItem();
        address = new javax.swing.JMenuItem();
        addressDomain = new javax.swing.JMenuItem();
        constantInteger = new javax.swing.JMenuItem();
        constantFloat = new javax.swing.JMenuItem();
        constantComplex = new javax.swing.JMenuItem();
        emails = new javax.swing.JMenuItem();
        mntmHelp = new javax.swing.JMenu();
        mntmAbout = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("File Editor");
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(350, 300));
        setVisible(false);

        textMain.setColumns(20);
        textMain.setToolTipText("Main Text Area");
        textMain.setAutoscrolls(false);
        jScrollPane1.setViewportView(textMain);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        mntmFile_1.setText("File");

        mntmOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mntmOpen.setText("Open");
        mntmOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntmOpenActionPerformed(evt);
            }
        });
        mntmFile_1.add(mntmOpen);

        mntmSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mntmSave.setText("Save");
        mntmSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntmSaveActionPerformed(evt);
            }
        });
        mntmFile_1.add(mntmSave);

        mntmSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mntmSaveAs.setText("Save As");
        mntmSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntmSaveAsActionPerformed(evt);
            }
        });
        mntmFile_1.add(mntmSaveAs);

        mntmInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        mntmInfo.setText("Info");
        mntmInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntmInfoActionPerformed(evt);
            }
        });
        mntmFile_1.add(mntmInfo);
        mntmFile_1.add(jSeparator1);

        mntmExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mntmExit.setText("Exit");
        mntmExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntmExitActionPerformed(evt);
            }
        });
        mntmFile_1.add(mntmExit);

        jMenuBar1.add(mntmFile_1);

        mntmFind.setText("Find");

        nameSurname.setText("Name and Surname");
        nameSurname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameSurnameActionPerformed(evt);
            }
        });
        mntmFind.add(nameSurname);

        surnameInitials.setText("Surname and Initials");
        surnameInitials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameInitialsActionPerformed(evt);
            }
        });
        mntmFind.add(surnameInitials);

        javaKeywords.setText("Java Keywords");
        javaKeywords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javaKeywordsActionPerformed(evt);
            }
        });
        mntmFind.add(javaKeywords);

        address.setText("Ukrainian Address");
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        mntmFind.add(address);

        addressDomain.setText("Domain Address");
        addressDomain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressDomainActionPerformed(evt);
            }
        });
        mntmFind.add(addressDomain);

        constantInteger.setText("Integer Constants");
        constantInteger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constantIntegerActionPerformed(evt);
            }
        });
        mntmFind.add(constantInteger);

        constantFloat.setText("Float Constant");
        constantFloat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constantFloatActionPerformed(evt);
            }
        });
        mntmFind.add(constantFloat);

        constantComplex.setText("Complex Constant");
        constantComplex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constantComplexActionPerformed(evt);
            }
        });
        mntmFind.add(constantComplex);

        emails.setText("All Emails");
        emails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailsActionPerformed(evt);
            }
        });
        mntmFind.add(emails);

        jMenuBar1.add(mntmFind);

        mntmHelp.setText("Help");

        mntmAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mntmAbout.setText("About");
        mntmAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntmAboutActionPerformed(evt);
            }
        });
        mntmHelp.add(mntmAbout);

        jMenuBar1.add(mntmHelp);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Events Listeners
     */

    private void mntmSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntmSaveActionPerformed
        stateChanging(1);                                                 //Save
    }//GEN-LAST:event_mntmSaveActionPerformed

    private void mntmInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntmInfoActionPerformed
        stateChanging(3);						  //Info
    }//GEN-LAST:event_mntmInfoActionPerformed

    private void mntmExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntmExitActionPerformed
        stateChanging(4);						 // Exit
    }//GEN-LAST:event_mntmExitActionPerformed

    private void mntmOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntmOpenActionPerformed
        stateChanging(0);                                                 //Open
    }//GEN-LAST:event_mntmOpenActionPerformed

    private void mntmSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntmSaveAsActionPerformed
        stateChanging(2);						//SaveAs
    }//GEN-LAST:event_mntmSaveAsActionPerformed

    private void mntmAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntmAboutActionPerformed
        stateChanging(5);						// About
    }//GEN-LAST:event_mntmAboutActionPerformed

    private void nameSurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameSurnameActionPerformed
        findEverything(0);					 // Name Surname
    }//GEN-LAST:event_nameSurnameActionPerformed

    private void surnameInitialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameInitialsActionPerformed
        findEverything(1);				 // Surname and Initials
    }//GEN-LAST:event_surnameInitialsActionPerformed

    private void javaKeywordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_javaKeywordsActionPerformed
        findEverything(2);                                      // Java Keywords
    }//GEN-LAST:event_javaKeywordsActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        findEverything(3);                                            // address
    }//GEN-LAST:event_addressActionPerformed

    private void addressDomainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressDomainActionPerformed
        findEverything(4);                                            // domains
    }//GEN-LAST:event_addressDomainActionPerformed

    private void constantIntegerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constantIntegerActionPerformed
        findEverything(5);                                            // integer
    }//GEN-LAST:event_constantIntegerActionPerformed

    private void constantFloatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constantFloatActionPerformed
        findEverything(6);                                              // float
    }//GEN-LAST:event_constantFloatActionPerformed

    private void constantComplexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constantComplexActionPerformed
        findEverything(7);                                            // complex
    }//GEN-LAST:event_constantComplexActionPerformed

    private void emailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailsActionPerformed
        findEverything(8);                                             // emails
    }//GEN-LAST:event_emailsActionPerformed

    /**
     * Serving methods
     *
     * @param message get value to show as a message box
     * @return value that indicates user choice in message box
     */
    public int showError(String message) {
        int value = JOptionPane.showConfirmDialog(this,
                message, "Error...", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        return value;
    }

    public int showMessage(String message) {
        int value = JOptionPane.showConfirmDialog(this,
                message, "Info...", JOptionPane.OK_OPTION);
        return value;
    }

    private File openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setDialogTitle("Open");
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("TXT files", "txt"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("DAT files", "dat"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("RTF files", "dat"));
        fileChooser.setAcceptAllFileFilterUsed(true);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null && selectedFile.exists()) {
                return selectedFile;
            } else {
                this.showError("Your file in exists!");
            }
        }
        return null;
    }

    private void getFileInfo() {
        if (isModified) {
            stateChanging(1);
        }
        File file = openedFile;

        double fileSize = file.length() / 1024;
        int symbolsNumbers = textMain.getText().length();
        int paragraphCounter = 0, emptyStringCounter = 0;

        String content = textMain.getText();
        final BufferedReader br = new BufferedReader(new StringReader(content));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                paragraphCounter++;
                if (line.trim().isEmpty()) {
                    emptyStringCounter++;
                }
            }
        } catch (IOException e) {
            showError(e.toString());
        }

        int authorsPages = (int) (symbolsNumbers / 1800);
        int vowelsCounter = 0, consonantCounter = 0, digitsCounter = 0, punctuationCounter = 0, latinLetterCounter = 0, cyrylicLetterCounter = 0;

        for (int i = 0; i < content.length(); i++) {
            String s = String.valueOf(content.charAt(i));
            if (s.matches("(.*)([aeiouyAEIOUYаеєиіїоуюяАЕЄИІЇОУЮЯ]+)(.*)")) {
                vowelsCounter++;
            }
            if (s.matches("(.*)([bcdfghgklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXYZбвгджзклмнпрстфхцчшщБВГДЖЗКЛМНПРСТФХЦЧШЩ]+)(.*)")) {
                consonantCounter++;
            }
            if (s.matches("(.*)([0-9]+)(.*)")) {
                digitsCounter++;
            }
            if (s.matches("(.*)([\\.\\,\\!\\-\\–\\:\\;\\?]+)(.*)")) {
                punctuationCounter++;
            }
            if (s.matches("(.*)([A-Za-z]+)(.*)")) {
                latinLetterCounter++;
            }
            if (s.matches("(.*)([А-Яа-я]+)(.*)")) {
                cyrylicLetterCounter++;
            }
        }
        String out = "                  File size: " + fileSize + "\n"
                + " Symbols number: " + symbolsNumbers + "\n"
                + "           Paragraphs: " + paragraphCounter + "\n"
                + "       Empty strings: " + emptyStringCounter + "\n"
                + "     Author's Pages: " + authorsPages + "\n"
                + "	Vowels: " + vowelsCounter + "\n"
                + "          Consonants: " + consonantCounter + "\n"
                + "                     Digits: " + digitsCounter + "\n"
                + "          Punctuation: " + punctuationCounter + "\n"
                + "           Latin letters: " + latinLetterCounter + "\n"
                + "        Cyrylic letters: " + cyrylicLetterCounter + "\n";
        showMessage(out);

    }

    /**
     * Finding Controller
     *
     * @param index is value sent from menu item that indicate what method
     * should find
     */
    private void findEverything(int index) {
        if (isOpened) {
            String content = textMain.getText();
            switch (index) {
                case 0:
                    try {
                        int fst = -1, snd = -1;
                        Pattern nameSurname = Pattern.compile("([А-Я]{1}[а-я]+ {1}[А-Я]{1}[а-я]+|[A-Z]{1}[a-z]+ {1}[A-Z]{1}[a-z]+)");
                        Matcher matcher = nameSurname.matcher(content);
                        matcher.find();
                        fst = matcher.start(0);
                        snd = matcher.end(0);
                        if (fst >= 0 && snd >= 0) {
                            textMain.select(fst, snd);
                        } else {
                            showError("Nothing is found!");
                        }
                    } catch (IllegalStateException e) {
                        showError(e.toString());
                    }
                    break;
                case 1:
                    try {
                        int fst = -1, snd = -1;
                        Pattern nameSurname = Pattern.compile("([А-Я]{1}[а-я]+ {1}[А-Я]{1}.[А-Я]{1}.|[A-Z]{1}[a-z]+ {1}[A-Z]{1}.[A-Z]{1}.)");
                        Matcher matcher = nameSurname.matcher(content);
                        matcher.find();
                        fst = matcher.start(0);
                        snd = matcher.end(0);
                        if (fst >= 0 && snd >= 0) {
                            textMain.select(fst, snd);
                        } else {
                            showError("Nothing is found!");
                        }
                    } catch (IllegalStateException e) {
                        showError(e.toString());
                    }
                    break;
                case 2:
                    try {
                        int fst = -1, snd = -1;
                        Pattern nameSurname = Pattern.compile("(boolean|char|string|int|double|float|for|while|class|static|private|protected|public)");
                        Matcher matcher = nameSurname.matcher(content);
                        matcher.find();
                        fst = matcher.start(0);
                        snd = matcher.end(0);
                        if (fst >= 0 && snd >= 0) {
                            textMain.select(fst, snd);
                        } else {
                            showError("Nothing is found!");
                        }
                    } catch (IllegalStateException e) {
                        showError(e.toString());
                    }
                    break;
                case 3:
                    try {
                        int fst = -1, snd = -1;
                        Pattern nameSurname = Pattern.compile("([А-Я]{1}[а-я]+ [А-Я]{1}[а-я]+.? [А-Я]{1}[а-я]+.?, в?ул. [А-Я]{1}[а-я]+, [бу]?д. [0-9]+, кв. [0-9]+?, м?г?. [А-Я]{1}[а-я]+, [0-9]+)");
                        Matcher matcher = nameSurname.matcher(content);
                        matcher.find();
                        fst = matcher.start(0);
                        snd = matcher.end(0);
                        if (fst >= 0 && snd >= 0) {
                            textMain.select(fst, snd);
                        } else {
                            showError("Nothing is found!");
                        }
                    } catch (IllegalStateException e) {
                        showError(e.toString());
                    }
                    break;
                case 4:
                    try {
                        int fst = -1, snd = -1;
                        Pattern nameSurname = Pattern.compile("([a-z0-9.]+.edu.ua|[a-z0-9.]+.net.ua|[a-z0-9.]+.com.ua|[a-z0-9.]+.in.ua|[a-z0-9.]+.org.ua)");
                        Matcher matcher = nameSurname.matcher(content);
                        matcher.find();
                        fst = matcher.start(0);
                        snd = matcher.end(0);
                        if (fst >= 0 && snd >= 0) {
                            textMain.select(fst, snd);
                        } else {
                            showError("Nothing is found!");
                        }
                    } catch (IllegalStateException e) {
                        showError(e.toString());
                    }
                    break;
                case 5:
                    try {
                        int fst = -1, snd = -1;
                        Pattern nameSurname = Pattern.compile("(\"{1}[0-9]+\"{1}|'{1}[0-9]+'{1}|“{1}[0-9]+”{1}|‘{1}[0-9]+’{1})");
                        Matcher matcher = nameSurname.matcher(content);
                        matcher.find();
                        fst = matcher.start(0);
                        snd = matcher.end(0);
                        if (fst >= 0 && snd >= 0) {
                            textMain.select(fst, snd);
                        } else {
                            showError("Nothing is found!");
                        }
                    } catch (IllegalStateException e) {
                        showError(e.toString());
                    }
                    break;
                case 6:
                    try {
                        int fst = -1, snd = -1;
                        Pattern nameSurname = Pattern.compile("(\"{1}[0-9]+.[0-9]+\"{1}|'{1}[0-9]+.[0-9]+'{1}|“{1}[0-9]+.[0-9]+”{1}|‘{1}[0-9]+.[0-9]+’{1}|\"{1}[0-9]+,[0-9]+\"{1}|'{1}[0-9]+,[0-9]+'{1}|“{1}[0-9]+,[0-9]+”{1}|‘{1}[0-9]+,[0-9]+’{1})");
                        Matcher matcher = nameSurname.matcher(content);
                        matcher.find();
                        fst = matcher.start(0);
                        snd = matcher.end(0);
                        if (fst >= 0 && snd >= 0) {
                            textMain.select(fst, snd);
                        } else {
                            showError("Nothing is found!");
                        }
                    } catch (IllegalStateException e) {
                        showError(e.toString());
                    }
                    break;
                case 7:
                    try {
                        int fst = -1, snd = -1;
                        Pattern nameSurname = Pattern.compile("(\"{1}[0-9+\\-\\*iI]+\"{1}|'{1}[0-9+\\-\\*iI]+'{1})");
                        Matcher matcher = nameSurname.matcher(content);
                        matcher.find();
                        fst = matcher.start(0);
                        snd = matcher.end(0);
                        if (fst >= 0 && snd >= 0) {
                            textMain.select(fst, snd);
                        } else {
                            showError("Nothing is found!");
                        }
                    } catch (IllegalStateException e) {
                        showError(e.toString());
                    }
                    break;
                case 8:
                    try {
                        int fst = -1, snd = -1;
                        Pattern nameSurname = Pattern.compile("([a-z]+[0-9]?.@[a-z]+.[a-z]{2,4})");
                        Matcher matcher = nameSurname.matcher(content);
                        matcher.find();
                        fst = matcher.start(0);
                        snd = matcher.end(0);
                        if (fst >= 0 && snd >= 0) {
                            textMain.select(fst, snd);
                        } else {
                            showError("Nothing is found!");
                        }
                    } catch (IllegalStateException e) {
                        showError(e.toString());
                    }
                    break;
            }
        } else {
            showError("You haven't opened any file!");
        }
    };
    
    
    /**
     * State Change Controller
     * 
     * @param changeType indicate how state changes
     */
    private void stateChanging(int changeType) {
        switch (changeType) {
            case 0:
                if (isOpened) {
                    if (isModified) {
                        int areYouSure = JOptionPane.showConfirmDialog(this,
                        "Do you want to save your previous work? It could be lost!",
                        "Are you sure?..", JOptionPane.YES_NO_OPTION);
                        
                        if (areYouSure == JOptionPane.YES_OPTION) {
                            stateChanging(1);
                        } else {
                            openedFile = openFile();
                        }
                    }
                } else {
                    openedFile = openFile();
                    if (openedFile != null) {
                        try {
                            String content = new Scanner(openedFile).useDelimiter("\\Z").next();
                            if (!content.equals("")) {
                                textMain.setText(content);
                            }
                            isOpened = true;
                        } catch (IOException e) {
                            showError(e.toString());
                        }
                    } else {
                        showError("You haven't opened any file!");
                    }
                }
                break;
            case 1:
                if (isOpened && isModified) {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(openedFile))) {
                        bw.write(textMain.getText());
                    } catch (IOException e) {
                        showError(e.toString());
                    }
                }
                break;
            case 2:
                //String newFileName = saveFile();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(openedFile))) {
                    bw.write(textMain.getText());
                } catch (IOException e) {
                    showError(e.toString());
                } finally {
                    JOptionPane.showMessageDialog(this, "Successful saved!", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case 3:
                if (isOpened) {
                    getFileInfo();
                } else {
                    showError("You haven't opened any file! Try to do this before getting file info!");
                }
                break;
            case 4:
                int areYouSure = JOptionPane.showConfirmDialog(this,
                        "Do you want to save your previous work? It could be lost!",
                        "Are you sure?..", JOptionPane.YES_NO_OPTION);

                if (areYouSure == JOptionPane.YES_OPTION) {
                    stateChanging(1);
                    System.exit(0); 
                } else {
                    System.exit(0);
                }
                break;
            case 5:
                JOptionPane.showMessageDialog(this, "Laboratory task №2. 5135-2 group, Andrii Dubovyk", "About", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    };


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem address;
    private javax.swing.JMenuItem addressDomain;
    private javax.swing.JMenuItem constantComplex;
    private javax.swing.JMenuItem constantFloat;
    private javax.swing.JMenuItem constantInteger;
    private javax.swing.JMenuItem emails;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem javaKeywords;
    private javax.swing.JMenuItem mntmAbout;
    private javax.swing.JMenuItem mntmExit;
    private javax.swing.JMenu mntmFile_1;
    private javax.swing.JMenu mntmFind;
    private javax.swing.JMenu mntmHelp;
    private javax.swing.JMenuItem mntmInfo;
    private javax.swing.JMenuItem mntmOpen;
    private javax.swing.JMenuItem mntmSave;
    private javax.swing.JMenuItem mntmSaveAs;
    private javax.swing.JMenuItem nameSurname;
    private javax.swing.JMenuItem surnameInitials;
    private javax.swing.JTextArea textMain;
    // End of variables declaration//GEN-END:variables
}
