package component.ComponentsForPanelOrder;

import component.PanelForMainMenu.PanelOrder;
import customTable.TableCustom;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.Object.HoaDon;
import model.Object.HoaDonChiTiet;
import model.DAO.HoaDonChiTietDAO;
import model.DAO.HoaDonDAO;
import model.Object.KhachHang;
import model.DAO.KhachHangDAO;
import model.DAO.KhoHangChiTietDAO;
import model.Object.KhoHang;
import model.DAO.KhoHangDAO;
import model.Object.SanPham;
import model.DAO.SanPhamDAO;
import model.Object.KhoHangChiTiet;
import model.Object.SanPhamDatHang;
import util.DateUtils;

public class TabPanelExport extends javax.swing.JPanel {

    private String userRole = "QL";

    private int index = -1;
    private List<SanPhamDatHang> sanPhamDatHangList = new ArrayList<>();

    public PanelOrder pnlOrder;

    private DefaultTableModel modelTblOrder;
    private DefaultTableModel modelTblDetail;

    private Connection connection;
    private HoaDonDAO hoaDonDAO;
    private HoaDonChiTietDAO hdctDAO;
    private KhachHangDAO khachHangDAO;
    private SanPhamDAO sanPhamDAO;
    private KhoHangDAO khoHangDAO;
    private KhoHangChiTietDAO khctDAO;

    public TabPanelExport() {
        initComponents();

        modelTblOrder = (DefaultTableModel) tblExportOrder.getModel();
        modelTblDetail = (DefaultTableModel) tblExportDetail.getModel();

        TableColumnModel columnModelTblOrder = tblExportOrder.getColumnModel();

        columnModelTblOrder.getColumn(0).setPreferredWidth(20);
        columnModelTblOrder.getColumn(1).setPreferredWidth(60);
        columnModelTblOrder.getColumn(2).setPreferredWidth(180);
        columnModelTblOrder.getColumn(3).setPreferredWidth(50);
        columnModelTblOrder.getColumn(4).setPreferredWidth(50);
        columnModelTblOrder.getColumn(5).setPreferredWidth(50);

        TableColumnModel columnModelTblOrderDetail = tblExportDetail.getColumnModel();

        columnModelTblOrderDetail.getColumn(0).setPreferredWidth(10);
        columnModelTblOrderDetail.getColumn(1).setPreferredWidth(100);
        columnModelTblOrderDetail.getColumn(2).setPreferredWidth(20);

        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.DEFAULT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlExport = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblExportDetail = new javax.swing.JTable();
        lblExportOrderDetail = new javax.swing.JLabel();
        lblExportOrderID = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExportOrder = new javax.swing.JTable();
        txtExportID = new javax.swing.JTextField();
        lblImportWarehouse = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        lbExportDate = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        txtExportDate = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        lblTrangThai = new javax.swing.JLabel();
        pnlThongTinKhachHang = new javax.swing.JPanel();
        lblTenKhach = new javax.swing.JLabel();
        btnOldCustomer = new javax.swing.JButton();
        lblSDT = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        lblCustomerID = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        lblCustomerPhone = new javax.swing.JLabel();
        lblCustomerAddress = new javax.swing.JLabel();
        btnNewCustomer = new javax.swing.JButton();
        btnEditCustomerInfo = new javax.swing.JButton();
        cboExportWarehouse = new javax.swing.JComboBox<>();
        lblStatus = new javax.swing.JLabel();
        btnExportProduct = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSuccess = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        pnlExport.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        tblExportDetail.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tblExportDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ SP", "TÊN SP ", "SỐ LƯỢNG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblExportDetail.setFocusable(false);
        tblExportDetail.setRowSelectionAllowed(false);
        tblExportDetail.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblExportDetail.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblExportDetail);

        lblExportOrderDetail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblExportOrderDetail.setText("ĐƠN HÀNG CHI TIẾT");

        lblExportOrderID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblExportOrderID.setText("MÃ HÓA ĐƠN");

        tblExportOrder.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tblExportOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MÃ HĐ", "KHO XUẤT HÀNG", "TÊN KHÁCH", "NGÀY LẬP", "LOẠI ĐƠN", "TRẠNG THÁI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblExportOrder.setFocusable(false);
        tblExportOrder.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblExportOrder.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblExportOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblExportOrderMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblExportOrder);

        txtExportID.setEditable(false);
        txtExportID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtExportID.setText("TỰ ĐỘNG TẠO MÃ SỐ");
        txtExportID.setFocusable(false);

        lblImportWarehouse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblImportWarehouse.setText("KHO LẤY HÀNG");

        btnClear.setBackground(new java.awt.Color(0, 0, 0));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ButtonIcon/clear.png"))); // NOI18N
        btnClear.setFocusable(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        lbExportDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbExportDate.setText("NGÀY LẬP ĐƠN");

        btnSave.setBackground(new java.awt.Color(0, 51, 153));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(242, 242, 242));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ButtonIcon/save.png"))); // NOI18N
        btnSave.setEnabled(false);
        btnSave.setFocusable(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtExportDate.setEditable(false);
        txtExportDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtExportDate.setFocusable(false);

        btnAdd.setBackground(new java.awt.Color(0, 153, 51));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(242, 242, 242));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ButtonIcon/add.png"))); // NOI18N
        btnAdd.setFocusable(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblTrangThai.setText("Trạng thái đơn hàng:");

        pnlThongTinKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "KHÁCH HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10))); // NOI18N

        lblTenKhach.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblTenKhach.setText("TÊN KHÁCH");

        btnOldCustomer.setBackground(new java.awt.Color(0, 102, 102));
        btnOldCustomer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOldCustomer.setForeground(new java.awt.Color(242, 242, 242));
        btnOldCustomer.setText("KHÁCH HÀNG CŨ");
        btnOldCustomer.setFocusable(false);
        btnOldCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOldCustomerActionPerformed(evt);
            }
        });

        lblSDT.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblSDT.setText("SỐ ĐIỆN THOẠI");

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblDiaChi.setText("ĐỊA CHỈ");

        lblCustomerID.setBackground(new java.awt.Color(255, 255, 255));
        lblCustomerID.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        lblCustomerID.setForeground(new java.awt.Color(255, 255, 255));

        lblCustomerName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        lblCustomerPhone.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        lblCustomerAddress.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        btnNewCustomer.setBackground(new java.awt.Color(102, 255, 255));
        btnNewCustomer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNewCustomer.setForeground(new java.awt.Color(51, 51, 51));
        btnNewCustomer.setText("KHÁCH HÀNG MỚI");
        btnNewCustomer.setFocusable(false);
        btnNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCustomerActionPerformed(evt);
            }
        });

        btnEditCustomerInfo.setBackground(new java.awt.Color(0, 51, 51));
        btnEditCustomerInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditCustomerInfo.setForeground(new java.awt.Color(242, 242, 242));
        btnEditCustomerInfo.setText("SỬA THÔNG TIN");
        btnEditCustomerInfo.setFocusable(false);
        btnEditCustomerInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCustomerInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThongTinKhachHangLayout = new javax.swing.GroupLayout(pnlThongTinKhachHang);
        pnlThongTinKhachHang.setLayout(pnlThongTinKhachHangLayout);
        pnlThongTinKhachHangLayout.setHorizontalGroup(
            pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenKhach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblCustomerPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(lblCustomerName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCustomerAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnNewCustomer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(btnEditCustomerInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOldCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCustomerID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(143, 143, 143))
        );
        pnlThongTinKhachHangLayout.setVerticalGroup(
            pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinKhachHangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnOldCustomer))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNewCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCustomerPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(lblCustomerID)
                .addGap(0, 0, 0)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditCustomerInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCustomerAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        cboExportWarehouse.setFocusable(false);
        cboExportWarehouse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboExportWarehouseItemStateChanged(evt);
            }
        });

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStatus.setText("Đang tạo");

        btnExportProduct.setBackground(new java.awt.Color(102, 0, 102));
        btnExportProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExportProduct.setForeground(new java.awt.Color(242, 242, 242));
        btnExportProduct.setText("MENU SẢN PHẨM");
        btnExportProduct.setFocusable(false);
        btnExportProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportProductActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ButtonIcon/delete.png"))); // NOI18N
        btnDelete.setEnabled(false);
        btnDelete.setFocusable(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSuccess.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSuccess.setText("SUCCESSIFY");
        btnSuccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuccessActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 255, 255));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(204, 0, 0));
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlExportLayout = new javax.swing.GroupLayout(pnlExport);
        pnlExport.setLayout(pnlExportLayout);
        pnlExportLayout.setHorizontalGroup(
            pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlExportLayout.createSequentialGroup()
                        .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlExportLayout.createSequentialGroup()
                                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExportLayout.createSequentialGroup()
                                        .addComponent(lblExportOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(pnlExportLayout.createSequentialGroup()
                                        .addComponent(lblImportWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cboExportWarehouse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtExportID, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlExportLayout.createSequentialGroup()
                                        .addComponent(lbExportDate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                        .addComponent(txtExportDate, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnExportProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(pnlThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 587, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlExportLayout.createSequentialGroup()
                                .addComponent(lblTrangThai)
                                .addGap(18, 18, 18)
                                .addComponent(lblStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancel))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(pnlExportLayout.createSequentialGroup()
                                .addComponent(lblExportOrderDetail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                                .addComponent(btnSuccess))))
                    .addGroup(pnlExportLayout.createSequentialGroup()
                        .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addGap(6, 6, 6))
        );
        pnlExportLayout.setVerticalGroup(
            pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExportID)
                    .addComponent(lblExportOrderDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExportOrderID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbExportDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExportDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuccess))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlExportLayout.createSequentialGroup()
                        .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblImportWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboExportWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnExportProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlThongTinKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlExportLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus)
                            .addComponent(btnCancel))))
                .addGap(14, 14, 14)
                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlExportLayout.createSequentialGroup()
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 942, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnlExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblExportOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExportOrderMousePressed
        index = tblExportOrder.getSelectedRow();
        int maHd = (int) modelTblOrder.getValueAt(index, 0);
        writeForm(maHd);
        buttonOnUpdate();
    }//GEN-LAST:event_tblExportOrderMousePressed

    private void btnExportProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportProductActionPerformed
        PopupExportProductSelection popUpProductMenu = new PopupExportProductSelection(this);
        popUpProductMenu.setVisible(true);
    }//GEN-LAST:event_btnExportProductActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void cboExportWarehouseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboExportWarehouseItemStateChanged
        modelTblDetail.setRowCount(0);

        btnExportProduct.setEnabled(true);

        if (cboExportWarehouse.getSelectedItem() != null) {
            if (cboExportWarehouse.getSelectedItem().equals("CHỜ BỔ SUNG")
                    || cboExportWarehouse.getSelectedItem() == null) {
                btnExportProduct.setEnabled(false);
            }
        }

    }//GEN-LAST:event_cboExportWarehouseItemStateChanged

    private void btnEditCustomerInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCustomerInfoActionPerformed
        String id = lblCustomerID.getText();
        String ten = lblCustomerName.getText();
        String sdt = lblCustomerPhone.getText();
        String diaChi = lblCustomerAddress.getText();

        if (id.isBlank() || ten.isBlank() || sdt.isBlank() || diaChi.isBlank()) {
            errorMessage("Không có thông tin khách hàng để chỉnh sửa!!!");
        } else {
            PopupEditCustomerInfo popupEditCustomerInfo = new PopupEditCustomerInfo(this);
            popupEditCustomerInfo.setVisible(true);
        }

    }//GEN-LAST:event_btnEditCustomerInfoActionPerformed

    private void btnNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCustomerActionPerformed
        PopupNewCustomer popupNewCustomer = new PopupNewCustomer(this);
        popupNewCustomer.setVisible(true);
    }//GEN-LAST:event_btnNewCustomerActionPerformed

    private void btnOldCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOldCustomerActionPerformed
        PopupOldCustomer popupOldCustomer = new PopupOldCustomer(this);
        popupOldCustomer.setVisible(true);
    }//GEN-LAST:event_btnOldCustomerActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            addHoaDon();
        } catch (SQLException ex) {
            Logger.getLogger(TabPanelExport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            updateHoaDon();
        } catch (SQLException ex) {
            Logger.getLogger(TabPanelExport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            deleteHoaDon();
        } catch (SQLException ex) {
            Logger.getLogger(TabPanelExport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSuccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuccessActionPerformed
        try {
            successifyHoaDon();
        } catch (SQLException ex) {
            Logger.getLogger(TabPanelImport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuccessActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        try {
            cancelHoaDon();
        } catch (SQLException ex) {
            Logger.getLogger(TabPanelExport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCancelActionPerformed
    ////////////////////////////////////////////////////////////////////////////

    public void errorMessage(String str) {
        JOptionPane.showMessageDialog(null, str, "LỖI", JOptionPane.ERROR_MESSAGE);
    }

    public boolean customConfirmDialog(String str) {
        int i = JOptionPane.showConfirmDialog(null, str, "Xác nhận",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        return i == JOptionPane.YES_OPTION;
    }
    ////////////////////////////////////////////////////////////////////////////

    public void getConnection(Connection connection, PanelOrder panelOrder) {
        this.connection = connection;
        this.pnlOrder = panelOrder;
        this.userRole = this.pnlOrder.getUserRole();

        if (this.userRole.equals("NV")) {
            btnDelete.setEnabled(false);
        }

        hoaDonDAO = new HoaDonDAO(this.connection);
        hdctDAO = new HoaDonChiTietDAO(this.connection);
        khachHangDAO = new KhachHangDAO(this.connection);
        sanPhamDAO = new SanPhamDAO(this.connection);
        khoHangDAO = new KhoHangDAO(this.connection);
        khctDAO = new KhoHangChiTietDAO(this.connection);

        addEventForTblDetail();
        loadDataToTblOrder();
    }

    public void resetPanel() {
        clearForm();

        loadDataToTblOrder();

        if (index != -1) {
            dragTableToIndex(index);
        }
    }

    public void dragTableToIndex(int i) {
        tblExportOrder.requestFocus();
        tblExportOrder.changeSelection(i, 0, false, false);
        tblExportOrder.setRowSelectionInterval(i, i);
        writeForm((int) tblExportOrder.getValueAt(i, 0));
        buttonOnUpdate();
    }

    public void findSp(int maHd) {
        int columnCount = tblExportOrder.getRowCount();

        for (int i = 0; i < columnCount; i++) {
            int maHDTbl = (int) tblExportOrder.getValueAt(i, 0);

            if (maHd == maHDTbl) {
                index = i;
                break;
            }
        }

        dragTableToIndex(index);
    }

    public Connection getPnlConnection() {
        return this.connection;
    }

    public void loadDataToTblOrder() {
        try {
            modelTblOrder.setRowCount(0);

            List<HoaDon> hoaDonList = hoaDonDAO.findExportOrder();

            for (HoaDon hd : hoaDonList) {
                KhoHang kho = khoHangDAO.findById(hd.getMaKho());
                int id = hd.getMaHd();
                String tenKho = kho.getTenKho();
                String tenKhach = khachHangDAO.getNameByID(hd.getMaKhach());
                String ngayLap = hd.getNgayLapHoaDon();
                String loaiHD = hd.getLoaiHoaDon();
                String trangThai = hd.getTrangThai();

                modelTblOrder.addRow(new Object[]{id, tenKho, tenKhach, ngayLap, loaiHD, trangThai});
            }

            List<KhoHang> khoHangList = khoHangDAO.findAll();

            cboExportWarehouse.removeAllItems();
            for (KhoHang kh : khoHangList) {
                cboExportWarehouse.addItem(kh.getTenKho());
            }
            cboExportWarehouse.addItem("CHỜ BỔ SUNG");
            cboExportWarehouse.setSelectedItem("CHỜ BỔ SUNG");

            btnExportProduct.setEnabled(false);

            txtExportDate.setText(getTodayDate());
        } catch (SQLException ex) {
        }
    }

    public void addEventForTblDetail() {
        modelTblDetail.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                sanPhamDatHangList.clear();

                if (tblExportDetail.getRowCount() != 0) {
                    int numberOfSp = tblExportDetail.getRowCount();

                    for (int i = 0; i < numberOfSp; i++) {
                        int maSp = (int) modelTblDetail.getValueAt(i, 0);
                        String tenSp = (String) modelTblDetail.getValueAt(i, 1);
                        int soLuong = (int) modelTblDetail.getValueAt(i, 2);

                        sanPhamDatHangList.add(new SanPhamDatHang(maSp, tenSp, soLuong));
                    }
                }
            }
        });
    }

    ////////////////////////////////////////////////////////////////////////////
    public void writeForm(int maHD) {
        try {
            HoaDon hoaDon = hoaDonDAO.findById(maHD);
            KhoHang kho = khoHangDAO.findById(hoaDon.getMaKho());
            KhachHang khach = khachHangDAO.findById(hoaDon.getMaKhach());

            txtExportID.setText(hoaDon.getMaHd() + "");
            cboExportWarehouse.setSelectedItem(kho.getTenKho());
            txtExportDate.setText(hoaDon.getNgayLapHoaDon());
            lblStatus.setText(hoaDon.getTrangThai());

            lblCustomerID.setText(khach.getMaKhach() + "");
            lblCustomerName.setText(khach.getTenKhach());
            lblCustomerPhone.setText(khach.getSdt());
            lblCustomerAddress.setText(khach.getDiaChi());

            modelTblDetail.setRowCount(0);
            List<HoaDonChiTiet> hdctList = hdctDAO.findByOrderID(maHD);

            for (HoaDonChiTiet hdct : hdctList) {
                SanPham sp = sanPhamDAO.findById(hdct.getMaSp());

                int maSP = sp.getMaSp();
                String tenSP = sp.getTenSp();
                int soLuong = hdct.getSoLuong();

                modelTblDetail.addRow(new Object[]{maSP, tenSP, soLuong});
            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearForm() {
        txtExportID.setText("TỰ ĐỘNG TẠO MÃ SỐ");

        txtExportDate.setText(getTodayDate());
        cboExportWarehouse.setSelectedItem("CHỜ BỔ SUNG");

        lblCustomerName.setText("");
        lblCustomerAddress.setText("");
        lblCustomerPhone.setText("");

        lblStatus.setText("Đang tạo");
        modelTblDetail.setRowCount(0);
        tblExportOrder.clearSelection();

        buttonOnAdd();
    }

    public HoaDon returnHoaDon() throws SQLException {
        int maHd = 0;

        try {
            maHd = Integer.parseInt(txtExportID.getText());
        } catch (NumberFormatException e) {
        }

        String ngayLapDon = DateUtils.convertToSQLDate(txtExportDate.getText());

        int maKho = khoHangDAO.findIdByName((String) cboExportWarehouse.getSelectedItem());

        int maKhach = Integer.parseInt(lblCustomerID.getText());

        String trangThai = "Pending";

        if (maHd != 0) {
            trangThai = lblStatus.getText();
        }

        return new HoaDon(maHd, maKhach, maKho, ngayLapDon, "Xuất", trangThai);
    }

    public List<HoaDonChiTiet> returnHDCT() {
        int maHd = 0;

        try {
            maHd = Integer.parseInt(txtExportID.getText());
        } catch (NumberFormatException e) {
        }

        List<HoaDonChiTiet> hdctList = new ArrayList<>();

        int hdctRow = tblExportDetail.getRowCount();

        if (hdctRow != 0) {
            for (int i = 0; i < hdctRow; i++) {
                int maSp = (int) modelTblDetail.getValueAt(i, 0);
                int soLuong = (int) modelTblDetail.getValueAt(i, 2);

                hdctList.add(new HoaDonChiTiet(maSp, maHd, soLuong));
            }
        }

        return hdctList;
    }

    public boolean validateInfo() {
        boolean flag = true;

        if (cboExportWarehouse.getSelectedItem().equals("CHỜ BỔ SUNG")) {
            errorMessage("Vui lòng chọn kho hàng");
            return false;
        }

        if (tblExportDetail.getRowCount() == 0) {
            errorMessage("Vui lòng chọn sản phẩm đặt hàng");
            flag = false;
        }

        if (lblCustomerName.getText().isBlank()
                || lblCustomerAddress.getText().isBlank()
                || lblCustomerPhone.getText().isBlank()
                || lblCustomerID.getText().isBlank()) {
            errorMessage("Vui lòng cung cấp thông tin khách hàng");
            return false;
        }

        return flag;
    }

    public boolean isTwoOrdersTheSame() throws SQLException {
        int maHd = Integer.parseInt(txtExportID.getText());

        HoaDon oldHoaDon = hoaDonDAO.findById(maHd);
        List<HoaDonChiTiet> oldHDCTList = hdctDAO.findByOrderID(oldHoaDon.getMaHd());

        HoaDon newHoaDon = returnHoaDon();
        List<HoaDonChiTiet> newHDCTList = returnHDCT();

        if (!oldHoaDon.equals(newHoaDon)) {
            return false;
        }

        if (!oldHDCTList.equals(newHDCTList)) {
            return false;
        }

        for (int i = 0; i < oldHDCTList.size(); i++) {
            if (!oldHDCTList.get(i).equals(newHDCTList.get(i))) {
                return false;
            }
        }

        return true;
    }

    public void addHoaDon() throws SQLException {
        if (validateInfo()) {
            if (customConfirmDialog("Thêm hóa đơn mới này?")) {
                HoaDon hoaDon = returnHoaDon();
                hoaDonDAO.insert(hoaDon);
                hoaDon = hoaDonDAO.findNewest();

                txtExportID.setText(hoaDon.getMaHd() + "");

                List<HoaDonChiTiet> hdctList = returnHDCT();

                for (HoaDonChiTiet hdct : hdctList) {
                    hdctDAO.insert(hdct);
                }

                index = 0;
                this.pnlOrder.askMainMenuToRestart();
                JOptionPane.showMessageDialog(null, "Thêm hóa đơn mới thành công!");
            }
        }
    }

    public void updateHoaDon() throws SQLException {
        if (!validateInfo()) {
            return;
        }

        int maHd = Integer.parseInt(txtExportID.getText());

        HoaDon oldHoaDon = hoaDonDAO.findById(maHd);
        List<HoaDonChiTiet> oldHDCTList = hdctDAO.findByOrderID(oldHoaDon.getMaHd());
        List<Integer> spInOldHD = new ArrayList<>();

        HoaDon newHoaDon = returnHoaDon();
        List<HoaDonChiTiet> newHDCTList = returnHDCT();
        List<Integer> spInNewHD = new ArrayList<>();

        int maKho = oldHoaDon.getMaKho();

        boolean diff = isTwoOrdersTheSame();

        if (oldHoaDon.getTrangThai().equals("Delivering")) {
            errorMessage("Không thể thay đổi thông tin hóa đơn ở trạng thái đang giao");
            clearForm();
            return;
        }

        if (!diff) {
            boolean confirmUpdate = customConfirmDialog("Tiếp tục cập nhật hóa đơn này?");
            if (confirmUpdate) {
                hoaDonDAO.update(newHoaDon);

                for (HoaDonChiTiet hdct : oldHDCTList) {
                    spInOldHD.add(hdct.getMaSp());
                }

                for (HoaDonChiTiet hdct : newHDCTList) {
                    spInNewHD.add(hdct.getMaSp());
                }

                List<Integer> deletedSp = new ArrayList<>();
                List<Integer> sameSp = new ArrayList<>();
                List<Integer> newSp = new ArrayList<>();

                for (Integer oldMaSp : spInOldHD) {
                    if (spInNewHD.contains(oldMaSp)) {
                        sameSp.add(oldMaSp);
                    } else {
                        deletedSp.add(oldMaSp);
                    }
                }

                for (Integer newMaSp : spInNewHD) {
                    if (!spInOldHD.contains(newMaSp)) {
                        newSp.add(newMaSp);
                    }
                }
                HoaDonChiTiet oldHDCT;
                KhoHangChiTiet khct;

                if (!deletedSp.isEmpty()) {
                    for (Integer maSp : deletedSp) {
                        hdctDAO.delete(maSp, maHd);
                    }
                }

                if (!sameSp.isEmpty()) {
                    for (Integer maSp : sameSp) {
                        oldHDCT = hdctDAO.findByProductAndOrderID(maSp, maHd);
                        khct = khctDAO.findOneByWarehouseAndProductID(maKho, maSp);

                        for (HoaDonChiTiet newHDCT : newHDCTList) {
                            if (newHDCT.getMaSp() == maSp) {
                                hdctDAO.update(newHDCT);
                                break;
                            }
                        }

                    }
                }

                if (!newSp.isEmpty()) {
                    for (Integer maSp : newSp) {
                        hdctDAO.delete(maSp, maHd);
                    }
                }

                this.pnlOrder.askMainMenuToRestart();
                JOptionPane.showMessageDialog(null, "Cập nhật hóa đơn thành công!");
            }
        }
    }

    public void deleteHoaDon() throws SQLException {
        int maHd = Integer.parseInt(txtExportID.getText());

        HoaDon hoaDon = hoaDonDAO.findById(maHd);

        String startDate = hoaDon.getNgayLapHoaDon();
        String today = getTodayDate();

        long daySinceCreated = DateUtils.dateCalculator(startDate, today);

        if (hoaDon.getTrangThai().equals("Delivering")) {
            errorMessage("Không thể xóa hóa đơn ở trạng thái ĐANG GIAO");
            clearForm();
            return;
        }

        if (hoaDon.getTrangThai().equals("Pending")) {
            boolean confirm = customConfirmDialog("Đơn hàng đang chờ được giao\n"
                    + "Nếu xóa đơn, sản phẩm đặt hàng sẽ được trả về kho");
            if (confirm) {
                List<HoaDonChiTiet> hdctList = hdctDAO.findByOrderID(maHd);
                KhoHangChiTiet khct = new KhoHangChiTiet();
                int maKho = khoHangDAO.findById(hoaDon.getMaKho()).getMaKho();

                for (HoaDonChiTiet hdct : hdctList) {
                    int maSp = hdct.getMaSp();
                    int traHang = hdct.getSoLuong();

                    khct = khctDAO.findOneByWarehouseAndProductID(maKho, maSp);

                    int tonKho = khct.getSoLuong();
                    int realTonKho = tonKho + traHang;

                    khct.setSoLuong(realTonKho);
                    khctDAO.update(khct);
                }

                hoaDonDAO.delete(maHd);
                index = -1;
                this.pnlOrder.askMainMenuToRestart();
                JOptionPane.showMessageDialog(null, "Xóa hóa đơn thành công!");
            }
        } else if (daySinceCreated < 360) {
            boolean confirm = customConfirmDialog("Đơn hàng này được tạo và có thời gian lưu trữ dưới 1 năm\n"
                    + "Bạn có chắc chắn muốn xóa đơn hàng này?");
            if (confirm) {
                hoaDonDAO.delete(maHd);
                index = -1;
                this.pnlOrder.askMainMenuToRestart();
                JOptionPane.showMessageDialog(null, "Xóa hóa đơn thành công!");
            }
        }
    }

    public void successifyHoaDon() throws SQLException {
        int maHd = (int) tblExportOrder.getValueAt(index, 0);

        if (maHd != 0) {

            HoaDon hoaDon = returnHoaDon();

            if (hoaDon.getTrangThai().equals("Pending")
                    || hoaDon.getTrangThai().equals("Delivering")) {
                boolean confirm = customConfirmDialog("Cập nhật trạng thái hóa đơn?");

                if (confirm) {
                    hoaDon.setTrangThai("Success");

                    System.out.println(hoaDon.getTrangThai());
                    hoaDonDAO.update(hoaDon);

                    this.pnlOrder.askMainMenuToRestart();
                    JOptionPane.showMessageDialog(null, "Hóa đơn được giao thành công!");
                }
            }
        }
    }

    public void cancelHoaDon() throws SQLException {
        int maHd = (int) tblExportOrder.getValueAt(index, 0);

        if (maHd != 0) {

            HoaDon hoaDon = returnHoaDon();

            if (hoaDon.getTrangThai().equals("Pending")
                    || hoaDon.getTrangThai().equals("Delivering")) {
                boolean confirm = customConfirmDialog("Hủy hóa đơn này?");

                if (confirm) {
                    hoaDon.setTrangThai("Cancelled");

                    hoaDonDAO.update(hoaDon);

                    this.pnlOrder.askMainMenuToRestart();
                    JOptionPane.showMessageDialog(null, "Hóa đơn đã bị hủy !");
                }
            }
        }
    }
////////////////////////////////////////////////////////////////////////////

    public int getCurrentWarehouseID() {
        int maKho = 0;

        try {
            maKho = khoHangDAO.findIdByName((String) cboExportWarehouse.getSelectedItem());

        } catch (SQLException ex) {
            Logger.getLogger(PanelOrder.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return maKho;
    }

    public void addCustomerInfo(KhachHang khach) {
        lblCustomerID.setText(khach.getMaKhach() + "");
        lblCustomerName.setText(khach.getTenKhach());
        lblCustomerPhone.setText(khach.getSdt());
        lblCustomerAddress.setText(khach.getDiaChi());
    }

    public void addDetailProduct(List<SanPhamDatHang> spdhlist) {
        modelTblDetail.setRowCount(0);

        for (SanPhamDatHang spdh : spdhlist) {
            int maSp = spdh.getMaSp();
            String tenSp = spdh.getTenSp();
            int soLuong = spdh.getSoLuong();

            modelTblDetail.addRow(new Object[]{maSp, tenSp, soLuong});
        }
    }

    public List<SanPhamDatHang> getSanPhamDatHangHienTai() {
        return this.sanPhamDatHangList;
    }

    public String getTodayDate() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return DateUtils.convertToEuropeanDate(date.toString());
    }

    public KhachHang getCurrentKhachHang() {
        try {
            return khachHangDAO.findById(Integer.parseInt(lblCustomerID.getText()));

        } catch (SQLException ex) {
            Logger.getLogger(TabPanelExport.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    ////////////////////////////////////////////////////////////////////////////
    public void buttonOnUpdate() {
        btnAdd.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(true);

        if (userRole.equals("NV")) {
            btnDelete.setEnabled(false);
        }
    }

    public void buttonOnAdd() {
        btnAdd.setEnabled(true);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    public javax.swing.JButton btnClear;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnEditCustomerInfo;
    public javax.swing.JButton btnExportProduct;
    public javax.swing.JButton btnNewCustomer;
    public javax.swing.JButton btnOldCustomer;
    public javax.swing.JButton btnSave;
    private javax.swing.JButton btnSuccess;
    public javax.swing.JComboBox<String> cboExportWarehouse;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbExportDate;
    private javax.swing.JLabel lblCustomerAddress;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblCustomerPhone;
    public javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblExportOrderDetail;
    private javax.swing.JLabel lblExportOrderID;
    private javax.swing.JLabel lblImportWarehouse;
    public javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblStatus;
    public javax.swing.JLabel lblTenKhach;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JPanel pnlExport;
    private javax.swing.JPanel pnlThongTinKhachHang;
    public javax.swing.JTable tblExportDetail;
    public javax.swing.JTable tblExportOrder;
    public javax.swing.JTextField txtExportDate;
    public javax.swing.JTextField txtExportID;
    // End of variables declaration//GEN-END:variables
}
