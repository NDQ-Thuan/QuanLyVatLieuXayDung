package component.PanelForMainMenu;

import customTable.TableCustom;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.Object.KhoHang;
import model.Object.KhoHangChiTiet;
import model.DAO.KhoHangChiTietDAO;
import model.DAO.KhoHangDAO;
import model.Object.LoaiHang;
import model.DAO.LoaiHangDAO;
import model.Object.NhaCungCap;
import model.DAO.NhaCungCapDAO;
import model.Object.SanPham;
import model.DAO.SanPhamDAO;
import swing.MainMenu;

public final class PanelProduct extends ConnectionPanel {

    private int index = -1;
    private DefaultTableModel modelTblProduct;
    private DefaultTableModel modelTblWarehouse;

    private SanPhamDAO sanPhamDAO;
    private LoaiHangDAO loaiHangDAO;
    private KhoHangDAO khoDAO;
    private KhoHangChiTietDAO khctDAO;
    private NhaCungCapDAO nccDAO;

    public PanelProduct() {
        initComponents();
        modelTblProduct = (DefaultTableModel) tblProduct.getModel();
        modelTblWarehouse = (DefaultTableModel) tblWarehouse.getModel();

        TableColumnModel columnModelTblProduct = tblProduct.getColumnModel();

        columnModelTblProduct.getColumn(0).setPreferredWidth(30);
        columnModelTblProduct.getColumn(1).setPreferredWidth(170);
        columnModelTblProduct.getColumn(2).setPreferredWidth(70);
        columnModelTblProduct.getColumn(3).setPreferredWidth(50);
        columnModelTblProduct.getColumn(4).setPreferredWidth(50);

        TableColumnModel columnModelTblWarehouse = tblWarehouse.getColumnModel();

        columnModelTblWarehouse.getColumn(0).setPreferredWidth(60);

        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.DEFAULT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProductInfo = new javax.swing.JPanel();
        lblSuppID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        txtDVT = new javax.swing.JTextField();
        lblSuppProduct = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnFlag = new javax.swing.JButton();
        txtPrice = new javax.swing.JTextField();
        lblSuppProduct1 = new javax.swing.JLabel();
        cboType = new javax.swing.JComboBox<>();
        cboSupplier = new javax.swing.JComboBox<>();
        btnClear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblWarehouse = new javax.swing.JTable();
        lblProductName = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        lblFlag = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        cboFilterType = new javax.swing.JComboBox<>();
        cboFilterDVT = new javax.swing.JComboBox<>();
        cboFilterPrice = new javax.swing.JComboBox<>();
        lblClearTypeFilter = new javax.swing.JLabel();
        lblClearDVTFilter = new javax.swing.JLabel();
        lblClearPriceFilter = new javax.swing.JLabel();
        txtFilterProductName = new javax.swing.JTextField();
        btnClearFilter = new javax.swing.JButton();

        pnlProductInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSuppID.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblSuppID.setText("MÃ SẢN PHẨM");

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtID.setText("TỰ ĐỘNG TẠO MÃ SỐ");
        txtID.setFocusable(false);

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblName.setText("LOẠI HÀNG");

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblAddress.setText("NHÀ CUNG CẤP");

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblPhone.setText("ĐƠN VỊ TÍNH");

        txtDVT.setEditable(false);
        txtDVT.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txtDVT.setFocusable(false);

        lblSuppProduct.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblSuppProduct.setText("GIÁ");

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(242, 242, 242));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ButtonIcon/add.png"))); // NOI18N
        btnAdd.setFocusable(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 0, 153));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(242, 242, 242));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ButtonIcon/save.png"))); // NOI18N
        btnSave.setEnabled(false);
        btnSave.setFocusable(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnFlag.setBackground(new java.awt.Color(204, 0, 0));
        btnFlag.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFlag.setForeground(new java.awt.Color(242, 242, 242));
        btnFlag.setText("FLAG");
        btnFlag.setEnabled(false);
        btnFlag.setFocusable(false);
        btnFlag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlagActionPerformed(evt);
            }
        });

        txtPrice.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
        });

        lblSuppProduct1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSuppProduct1.setText("LƯU TRỮ TẠI KHO");

        cboType.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        cboType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTypeItemStateChanged(evt);
            }
        });

        cboSupplier.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        btnClear.setBackground(new java.awt.Color(0, 0, 0));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ButtonIcon/clear.png"))); // NOI18N
        btnClear.setFocusable(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tblWarehouse.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        tblWarehouse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "KHO TRỮ", "SỐ LƯỢNG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblWarehouse.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblWarehouse.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblWarehouse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblWarehouseMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblWarehouse);

        lblProductName.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblProductName.setText("TÊN SẢN PHẨM");

        txtProductName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblFlag.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout pnlProductInfoLayout = new javax.swing.GroupLayout(pnlProductInfo);
        pnlProductInfo.setLayout(pnlProductInfoLayout);
        pnlProductInfoLayout.setHorizontalGroup(
            pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductInfoLayout.createSequentialGroup()
                        .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSuppID)
                            .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSuppProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProductName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID)
                            .addComponent(txtProductName)
                            .addComponent(cboSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDVT)
                            .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(pnlProductInfoLayout.createSequentialGroup()
                        .addComponent(lblSuppProduct1)
                        .addGap(18, 18, 18)
                        .addComponent(lblFlag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlProductInfoLayout.createSequentialGroup()
                        .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlProductInfoLayout.createSequentialGroup()
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnFlag, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlProductInfoLayout.setVerticalGroup(
            pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSuppID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID))
                .addGap(15, 15, 15)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductName))
                .addGap(15, 15, 15)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDVT))
                .addGap(15, 15, 15)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice)
                    .addComponent(lblSuppProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProductInfoLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblSuppProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlProductInfoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFlag, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlProductInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFlag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        tblProduct.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ SP", "TÊN SP", "LOẠI HÀNG", "ĐVT", "GIÁ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduct.setFocusable(false);
        tblProduct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProduct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProductMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        cboFilterType.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        cboFilterType.setForeground(new java.awt.Color(0, 0, 102));
        cboFilterType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboFilterType.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loại Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        cboFilterDVT.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        cboFilterDVT.setForeground(new java.awt.Color(153, 102, 0));
        cboFilterDVT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboFilterDVT.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đơn Vị Tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        cboFilterPrice.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        cboFilterPrice.setForeground(new java.awt.Color(0, 102, 0));
        cboFilterPrice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tăng dần", "Giảm dần", " " }));
        cboFilterPrice.setSelectedIndex(2);
        cboFilterPrice.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giá", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        lblClearTypeFilter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblClearTypeFilter.setForeground(new java.awt.Color(153, 0, 0));
        lblClearTypeFilter.setText("x");
        lblClearTypeFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClearTypeFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblClearTypeFilterMousePressed(evt);
            }
        });

        lblClearDVTFilter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblClearDVTFilter.setForeground(new java.awt.Color(153, 0, 0));
        lblClearDVTFilter.setText("x");
        lblClearDVTFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClearDVTFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblClearDVTFilterMousePressed(evt);
            }
        });

        lblClearPriceFilter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblClearPriceFilter.setForeground(new java.awt.Color(153, 0, 0));
        lblClearPriceFilter.setText("x");
        lblClearPriceFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClearPriceFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblClearPriceFilterMousePressed(evt);
            }
        });

        txtFilterProductName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        txtFilterProductName.setForeground(new java.awt.Color(153, 153, 153));
        txtFilterProductName.setText("Tên sản phẩm");
        txtFilterProductName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFilterProductNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFilterProductNameFocusLost(evt);
            }
        });
        txtFilterProductName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFilterProductNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFilterProductNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFilterProductNameKeyTyped(evt);
            }
        });

        btnClearFilter.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnClearFilter.setText("CLEAR");
        btnClearFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboFilterType, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblClearTypeFilter)
                        .addGap(41, 41, 41)
                        .addComponent(cboFilterDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblClearDVTFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboFilterPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblClearPriceFilter)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFilterProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearFilter)
                        .addGap(0, 16, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFilterProductName)
                        .addGap(2, 2, 2))
                    .addComponent(btnClearFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblClearTypeFilter)
                        .addComponent(cboFilterType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboFilterDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblClearDVTFilter))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblClearPriceFilter)
                        .addComponent(cboFilterPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnlProductInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlProductInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMousePressed
        index = tblProduct.getSelectedRow();
        int maSp = (int) modelTblProduct.getValueAt(index, 0);
        writeForm(maSp);
        buttonsWhenEditInfo();
    }//GEN-LAST:event_tblProductMousePressed

    private void btnFlagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlagActionPerformed
        if (btnFlag.getText().equals("FLAG")) {
            flagProduct();
        } else {
            unflagProduct();
        }
    }//GEN-LAST:event_btnFlagActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addProduct();
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPriceKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        updateProduct();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cboTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTypeItemStateChanged
        try {
            String dvt = loaiHangDAO.getDVTByProductType((String) cboType.getSelectedItem());
            if (dvt == null) {
                txtDVT.setText("");
            } else {
                txtDVT.setText(dvt);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboTypeItemStateChanged

    private void tblWarehouseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblWarehouseMousePressed
        Point point = evt.getPoint();
        int row = tblProduct.rowAtPoint(point);
        if (evt.getClickCount() == 2 && tblWarehouse.getSelectedRow() != -1) {
            String kho = (String) tblWarehouse.getValueAt(row, 0);

            int maSp = 0;
            maSp = (int) tblProduct.getValueAt(index, 0);

            this.mainMenu.switchCardWarehouse(kho, maSp);
        }
    }//GEN-LAST:event_tblWarehouseMousePressed

    private void lblClearTypeFilterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClearTypeFilterMousePressed
        cboFilterType.setSelectedItem(" ");
    }//GEN-LAST:event_lblClearTypeFilterMousePressed

    private void lblClearDVTFilterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClearDVTFilterMousePressed
        cboFilterDVT.setSelectedItem(" ");
    }//GEN-LAST:event_lblClearDVTFilterMousePressed

    private void lblClearPriceFilterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClearPriceFilterMousePressed
        cboFilterPrice.setSelectedItem(" ");
    }//GEN-LAST:event_lblClearPriceFilterMousePressed

    private void txtFilterProductNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFilterProductNameFocusGained
        if (txtFilterProductName.getText().trim().equalsIgnoreCase("Tên sản phẩm")) {
            txtFilterProductName.setText("");
            txtFilterProductName.setForeground(Color.BLACK);
            txtFilterProductName.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtFilterProductNameFocusGained

    private void txtFilterProductNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFilterProductNameFocusLost
        if (txtFilterProductName.getText().trim().isEmpty()) {
            txtFilterProductName.setText("Tên sản phẩm");
            txtFilterProductName.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtFilterProductNameFocusLost

    private void txtFilterProductNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterProductNameKeyTyped

    }//GEN-LAST:event_txtFilterProductNameKeyTyped

    private void btnClearFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFilterActionPerformed
        txtFilterProductName.setText("Tên sản phẩm");
        txtFilterProductName.setForeground(new Color(153, 153, 153));
        cboFilterType.setSelectedItem(" ");
        cboFilterDVT.setSelectedItem(" ");
        cboFilterPrice.setSelectedItem(" ");
    }//GEN-LAST:event_btnClearFilterActionPerformed

    private void txtFilterProductNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterProductNameKeyPressed
    }//GEN-LAST:event_txtFilterProductNameKeyPressed

    private void txtFilterProductNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterProductNameKeyReleased
        try {
            filterSanPham();
        } catch (SQLException ex) {
            Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFilterProductNameKeyReleased

    ////////////////////////////////////////////////////////////////////////////
    public void errorMessage(String str) {
        JOptionPane.showMessageDialog(null, str, "LỖI", JOptionPane.ERROR_MESSAGE);
    }

    public int customConfirmDialog(String str) {
        return JOptionPane.showConfirmDialog(null, str, "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public int confirmDeleteDialog() {
        return JOptionPane.showConfirmDialog(null, "Tiếp tục xóa thông tin?"
                + "\nThao tác này sẽ xóa thông tin sản phẩm đang được cung cấp"
                + "\nvà những hóa đơn chứa sản phẩm đó!!!", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public void fillFlagLabel() {
        lblFlag.setText("<html>Lưu ý: Sản phẩm này hiện đang ngừng bán<br>và tạm thời không thể được đặt hàng</html>");
    }

    public void buttonsWhenAddInfo() {
        btnAdd.setEnabled(true);
        btnSave.setEnabled(false);
        btnFlag.setEnabled(false);

        if (this.role.equals("NV")) {
            btnAdd.setEnabled(false);
        }
    }

    public void buttonsWhenEditInfo() {
        btnFlag.setEnabled(true);
        btnAdd.setEnabled(false);
        btnSave.setEnabled(true);

        if (this.role.equals("NV")) {
            btnFlag.setEnabled(false);
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    public void clearForm() {
        txtID.setText("TỰ ĐỘNG TẠO MÃ SỐ");
        txtProductName.setText("");
        cboSupplier.setSelectedItem("CHỜ BỔ SUNG");
        cboType.setSelectedItem("CHỜ BỔ SUNG");
        txtDVT.setText("");
        txtPrice.setText("");
        lblFlag.setText("");

        tblProduct.clearSelection();
        modelTblWarehouse.setRowCount(0);

        buttonsWhenAddInfo();
    }

    public void writeForm(int maSp) {
        try {
            SanPham sp = sanPhamDAO.findById(maSp);
            NhaCungCap ncc = nccDAO.findById(sp.getMaNcc());
            LoaiHang lh = loaiHangDAO.findById(sp.getMaLh());

            txtID.setText(sp.getMaSp() + "");
            txtProductName.setText(sp.getTenSp());
            cboType.setSelectedItem(lh.getTenLoai());
            cboSupplier.setSelectedItem(ncc.getTenNCC());
            txtDVT.setText(lh.getDvt());
            txtPrice.setText(sp.getGia() + "");

            List<KhoHangChiTiet> khctList = khctDAO.findAllByProductID(maSp);
            modelTblWarehouse.setRowCount(0);

            for (KhoHangChiTiet khct : khctList) {
                KhoHang kho = khoDAO.findById(khct.getMaKho());
                String tenKho = kho.getTenKho();
                int soLuong = khct.getSoLuong();
                modelTblWarehouse.addRow(new Object[]{tenKho, soLuong});
            }

            if (sp.isFlagged()) {
                if (btnFlag.getText().equals("FLAG")) {
                    btnFlag.setText("UNFLAG");
                    btnFlag.setBackground(new Color(204, 0, 204));
                }
                fillFlagLabel();
            } else if (btnFlag.getText().equals("UNFLAG")) {
                btnFlag.setText("FLAG");
                btnFlag.setBackground(new Color(204, 0, 0));
                lblFlag.setText("");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public SanPham readForm() throws SQLException {
        int maSp = -1;

        try {
            maSp = Integer.parseInt(txtID.getText());
        } catch (NumberFormatException e) {
        }

        String tenSp = txtProductName.getText();

        int maNcc = nccDAO.findIDByName((String) cboSupplier.getSelectedItem());

        LoaiHang lh = loaiHangDAO.findByNameAndDVT((String) cboType.getSelectedItem(), txtDVT.getText());
        int maLh = lh.getMaLh();

        int gia = Integer.parseInt(txtPrice.getText());

        if (maSp == -1) {
            return new SanPham(maLh, maNcc, tenSp, gia);
        }

        return new SanPham(maSp, maLh, maNcc, tenSp, gia);
    }

    public boolean validateInfo() {
        boolean flag = true;

        String tenSp = txtProductName.getText().trim();

        if (tenSp.isBlank() || txtPrice.getText().isBlank()) {
            errorMessage("Vui lòng không để trống thông tin sản phẩm!");
            flag = false;
            return flag;
        }

        if (tenSp.length() > 50) {
            errorMessage("Tên sản phẩm không được vượt quá 50 ký tự");
            flag = false;
            return flag;
        }

        if (cboType.getSelectedItem().equals("CHỜ BỔ SUNG")) {
            errorMessage("Vui lòng bổ sung thông tin loại hàng của sản phẩm!!!");
            flag = false;
            return flag;
        }

        if (cboSupplier.getSelectedItem().equals("CHỜ BỔ SUNG")) {
            int n = customConfirmDialog("Thông tin nhà cung cấp của sản phẩm đang bị bỏ trống!\nXác nhận?");

            if (n != JOptionPane.YES_OPTION) {
                flag = false;
                return flag;
            }
        }

        int price = Integer.parseInt(txtPrice.getText());

        if (price > 10000000) {
            errorMessage("Giá của sản phẩm không được vượt quá 10,000,000 VNĐ");
            flag = false;
        }

        return flag;
    }

    ////////////////////////////////////////////////////////////////////////////
    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;

        sanPhamDAO = new SanPhamDAO(this.connection);
        loaiHangDAO = new LoaiHangDAO(this.connection);
        khoDAO = new KhoHangDAO(this.connection);
        khctDAO = new KhoHangChiTietDAO(this.connection);
        nccDAO = new NhaCungCapDAO(this.connection);

        loadDataToTblProduct();
        loadDataToForm();
        addEventForCboFilter();
    }

    @Override
    public void connectMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        this.role = mainMenu.getUserRole();
        if (this.role.equals("NV")) {
            btnAdd.setEnabled(false);
        }
    }

    @Override
    public void resetPanelData() {
        clearForm();
        loadDataToTblProduct();
        loadDataToForm();

        if (index != -1) {
            dragTableToIndex(index);
            buttonsWhenEditInfo();
        }
    }

    public void loadDataToTblProduct() {
        try {
            modelTblProduct.setRowCount(0);
            List<SanPham> spList = sanPhamDAO.findAll();

            for (SanPham sp : spList) {
                LoaiHang loaiHang = loaiHangDAO.findById(sp.getMaLh());
                int id = sp.getMaSp();
                String tensp = sp.getTenSp();
                String tenlh = loaiHang.getTenLoai();
                String dvt = loaiHang.getDvt();
                int gia = sp.getGia();

                modelTblProduct.addRow(new Object[]{id, tensp, tenlh, dvt, gia});

                if (sp.isFlagged()) {
                    TableCustom.setRedRow(tblProduct, (tblProduct.getRowCount() - 1));
                } else {
                    TableCustom.setNormalRow(tblProduct, (tblProduct.getRowCount() - 1));
                }
            }
        } catch (SQLException ex) {
        }
    }

    public void loadDataToForm() {
        try {
            List<LoaiHang> lhList = loaiHangDAO.findAll();

            cboType.removeAllItems();

            for (LoaiHang lh : lhList) {
                cboType.addItem(lh.getTenLoai());

                int cboFilterTypeFilterCount = cboFilterType.getItemCount();

                if (cboFilterTypeFilterCount != lhList.size()) {
                    cboFilterType.addItem(lh.getTenLoai());
                }

                int cboFilterDVTFilterCount = cboFilterDVT.getItemCount();

                if (cboFilterDVTFilterCount == 0) {
                    cboFilterDVT.addItem(lh.getDvt());
                } else {
                    boolean flag = true;
                    for (int i = 0; i < cboFilterDVTFilterCount; i++) {
                        if (lh.getDvt().equals(cboFilterDVT.getItemAt(i))) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        cboFilterDVT.addItem(lh.getDvt());
                    }
                }
            }

            cboType.addItem("CHỜ BỔ SUNG");
            cboType.setSelectedItem("CHỜ BỔ SUNG");

            cboFilterType.setSelectedItem(" ");
            cboFilterDVT.setSelectedItem(" ");
            cboFilterPrice.setSelectedItem(" ");

            List<NhaCungCap> nccList = nccDAO.findAllByCustomQuery("SELECT * FROM NHACUNGCAP WHERE FLAG = 0");

            cboSupplier.removeAllItems();

            for (NhaCungCap ncc : nccList) {
                cboSupplier.addItem(ncc.getTenNCC());
            }
            cboSupplier.addItem("CHỜ BỔ SUNG");

            cboSupplier.setSelectedItem("CHỜ BỔ SUNG");
        } catch (SQLException ex) {
            Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addProduct() {
        if (validateInfo()) {
            if (customConfirmDialog("Tiếp tục thêm sản phẩm này?") == JOptionPane.YES_OPTION) {
                try {
                    SanPham sp = readForm();
                    sanPhamDAO.insert(sp);
                    index = tblProduct.getRowCount();
                    mainMenu.restartForm();
                    JOptionPane.showMessageDialog(null, "Thêm sản phẩm mới thành công!");
                } catch (SQLException ex) {
                    Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void updateProduct() {
        if (validateInfo()) {
            try {
                int maSp = (int) modelTblProduct.getValueAt(index, 0);
                SanPham old_SP = sanPhamDAO.findById(maSp);

                SanPham new_SP = readForm();
                new_SP.setFlag(sanPhamDAO.findById(maSp).isFlagged());

                if (!old_SP.equals(new_SP)) {
                    if (customConfirmDialog("Tiếp tục cập nhật thông tin?") == JOptionPane.YES_OPTION) {
                        sanPhamDAO.update(new_SP);
                        mainMenu.restartForm();
                        JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelSupplier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void flagProduct() {
        int maSp = (int) modelTblProduct.getValueAt(index, 0);

        if (customConfirmDialog("Tiếp tục đánh dấu sản phẩm?\n"
                + "Lưu ý: sản phẩm sẽ ngừng bán nếu bị đánh dấu")
                == JOptionPane.YES_OPTION) {
            try {
                sanPhamDAO.flag(maSp);
                index = -1;
                mainMenu.restartForm();
                JOptionPane.showMessageDialog(null, "Sản phẩm ngừng bán thành công!");

            } catch (SQLException ex) {
                Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void unflagProduct() {
        int maSp = (int) modelTblProduct.getValueAt(index, 0);

        if (customConfirmDialog("Tiếp tục bỏ đánh dấu sản phẩm?\n"
                + "Lưu ý: sản phẩm sẽ được bày bán nếu bỏ đánh dấu")
                == JOptionPane.YES_OPTION) {
            try {
                sanPhamDAO.unflag(maSp);
                index = -1;
                mainMenu.restartForm();
                JOptionPane.showMessageDialog(null, "Sản phẩm đã được bỏ đánh dấu thành công!");
            } catch (SQLException ex) {
                Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void loadDataToTblProductWithFilter(String query) {
        try {
            modelTblProduct.setRowCount(0);
            List<SanPham> spList = sanPhamDAO.findAllByCustomQuery(query);

            for (SanPham sp : spList) {
                LoaiHang loaiHang = loaiHangDAO.findById(sp.getMaLh());
                int id = sp.getMaSp();
                String tensp = sp.getTenSp();
                String tenlh = loaiHang.getTenLoai();
                String dvt = loaiHang.getDvt();
                int gia = sp.getGia();

                modelTblProduct.addRow(new Object[]{id, tensp, tenlh, dvt, gia});

                if (sp.isFlagged()) {
                    TableCustom.setRedRow(tblProduct, (tblProduct.getRowCount() - 1));
                } else {
                    TableCustom.setNormalRow(tblProduct, (tblProduct.getRowCount() - 1));
                }
            }
        } catch (SQLException ex) {
        }
    }

    public void filterSanPham() throws SQLException {
        String tenSp = txtFilterProductName.getText().trim();
        if (tenSp == null || tenSp.equalsIgnoreCase("Tên sản phẩm")) {
            tenSp = "";
        }

        String loaiHang = (String) cboFilterType.getSelectedItem();
        if (loaiHang == null) {
            loaiHang = "";
        }
        String dvt = (String) cboFilterDVT.getSelectedItem();
        if (dvt == null) {
            dvt = "";
        }

        String giaCondition = (String) cboFilterPrice.getSelectedItem();
        if (giaCondition == null) {
            giaCondition = "";
        }

        String customQuery = "SELECT * FROM SANPHAM sp JOIN LOAIHANG lh ON sp.MALH = lh.MALH";

        if (tenSp.isBlank() && loaiHang.isBlank() && dvt.isBlank() && giaCondition.isBlank()) {
            List<SanPham> spList = sanPhamDAO.findAll();

            index = -1;
            clearForm();
            loadDataToTblProduct();

        } else {
            if (!tenSp.isBlank()) {
                customQuery += " WHERE sp.TENSP LIKE N'%" + tenSp + "%'";
            }

            if (!loaiHang.isBlank()) {
                int maLh = loaiHangDAO.findIDByName(loaiHang);

                if (customQuery.contains("WHERE")) {
                    customQuery += " AND sp.MALH = " + maLh + "";
                } else {
                    customQuery += " WHERE sp.MALH = " + maLh + "";
                }

            }

            if (!dvt.isBlank()) {
                if (customQuery.contains("WHERE")) {
                    customQuery += " AND DVT LIKE N'" + dvt + "'";
                } else {
                    customQuery += " WHERE DVT LIKE N'" + dvt + "'";
                }
            }

            if (!giaCondition.isBlank()) {
                if (giaCondition.equals("Tăng dần")) {
                    customQuery += " ORDER BY GIA ASC";
                } else {
                    customQuery += " ORDER BY GIA DESC";
                }
            }

            clearForm();
            loadDataToTblProductWithFilter(customQuery);
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    public void dragTableToIndex(int i) {
        tblProduct.requestFocus();
        tblProduct.changeSelection(i, 0, false, false);
        tblProduct.setRowSelectionInterval(i, i);
        writeForm((int) modelTblProduct.getValueAt(i, 0));
    }

    public void findSp(int maSp) {
        int columnCount = tblProduct.getRowCount();

        for (int i = 0; i < columnCount; i++) {
            int maSpTbl = (int) modelTblProduct.getValueAt(i, 0);

            if (maSp == maSpTbl) {
                index = i;
                break;
            }
        }

        dragTableToIndex(index);
    }

    public void addEventForCboFilter() {
        ItemListener il = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        filterSanPham();
                    } catch (SQLException ex) {
                        Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        cboFilterType.addItemListener(il);
        cboFilterDVT.addItemListener(il);
        cboFilterPrice.addItemListener(il);
    }

    ////////////////////////////////////////////////////////////////////////////
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClearFilter;
    private javax.swing.JButton btnFlag;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboFilterDVT;
    private javax.swing.JComboBox<String> cboFilterPrice;
    private javax.swing.JComboBox<String> cboFilterType;
    private javax.swing.JComboBox<String> cboSupplier;
    private javax.swing.JComboBox<String> cboType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblClearDVTFilter;
    private javax.swing.JLabel lblClearPriceFilter;
    private javax.swing.JLabel lblClearTypeFilter;
    private javax.swing.JLabel lblFlag;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblSuppID;
    private javax.swing.JLabel lblSuppProduct;
    private javax.swing.JLabel lblSuppProduct1;
    private javax.swing.JPanel pnlProductInfo;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTable tblWarehouse;
    private javax.swing.JTextField txtDVT;
    private javax.swing.JTextField txtFilterProductName;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductName;
    // End of variables declaration//GEN-END:variables

}
