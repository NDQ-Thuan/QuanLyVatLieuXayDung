CREATE DATABASE QuanLyVatLieuXayDung;
GO


USE QuanLyVatLieuXayDung;
GO

-- USER
CREATE TABLE USERS(
	USERNAME NVARCHAR(50) NOT NULL
	CONSTRAINT PK_USERNAME PRIMARY KEY(USERNAME),
	PASSWORD VARCHAR(20),
	ROLE NVARCHAR(50)
);
GO


INSERT INTO USERS (USERNAME, PASSWORD, ROLE) 
VALUES
	('admin', 'admin', 'QL'),
	('nhanvien', 'nhanvien', 'NV')
GO


--MAIN
CREATE TABLE KHACHHANG (
    MAKHACH INT IDENTITY(1,1) PRIMARY KEY,
    TENKHACH NVARCHAR(50) NOT NULL,
    DIACHI NVARCHAR(100) NOT NULL,
    SDT VARCHAR(15) NOT NULL,
	FLAG BIT DEFAULT 0, -- Flag inactive
);
GO


CREATE TABLE NHACUNGCAP (
    MANCC INT IDENTITY(1,1) PRIMARY KEY,
    TENNCC NVARCHAR(50) NOT NULL,
    DIACHI NVARCHAR(100) NOT NULL,
    SDT VARCHAR(15) NOT NULL,	
	FLAG BIT DEFAULT 0, -- Flag inactive
);
GO


CREATE TABLE LOAIHANG (
    MALH INT IDENTITY(1,1) PRIMARY KEY,
    TENLOAI NVARCHAR(50) NOT NULL,
    DVT NVARCHAR(10) NOT NULL,
);
GO


CREATE TABLE SANPHAM (
    MASP INT IDENTITY(1,1) PRIMARY KEY,
    MALH INT NOT NULL,
    MANCC INT NULL,
	TENSP NVARCHAR(50) NOT NULL,
    GIA INT NOT NULL,
	FLAG BIT DEFAULT 0, -- Flag inactive
    FOREIGN KEY (MALH) REFERENCES LOAIHANG(MALH),
    FOREIGN KEY (MANCC) REFERENCES NHACUNGCAP(MANCC)
);
GO


CREATE TABLE KHOHANG (
    MAKHO INT IDENTITY(1,1) PRIMARY KEY,
	TENKHOHANG NVARCHAR(50) NOT NULL,
    DIACHI NVARCHAR(200) NOT NULL,
	SDTQUANLY VARCHAR(15) NULL,
);
GO


CREATE TABLE KHOHANGCHITIET (
    MAKHO INT NOT NULL,
    MASP INT NOT NULL,
    SOLUONG INT NOT NULL,
    FOREIGN KEY (MASP) REFERENCES SANPHAM(MASP),
	FOREIGN KEY (MAKHO) REFERENCES KHOHANG(MAKHO)
);
GO


CREATE TABLE HOADON (
    MAHD INT IDENTITY(1,1) PRIMARY KEY,
    MAKHACH INT NOT NULL,
	MAKHO INT NOT NULL,
    NGAYLAPHOADON DATE NOT NULL,
    LOAIHOADON NVARCHAR(10) NOT NULL,
    TRANGTHAI NVARCHAR(10) NOT NULL,
    FOREIGN KEY (MAKHACH) REFERENCES KHACHHANG(MAKHACH),
	FOREIGN KEY (MAKHO) REFERENCES KHOHANG(MAKHO)
);
GO


CREATE TABLE HOADONCHITIET (
    MASP INT NOT NULL,
    MAHD INT NOT NULL,
    SOLUONG INT NOT NULL,
    FOREIGN KEY (MASP) REFERENCES SANPHAM (MASP),
    FOREIGN KEY (MAHD) REFERENCES HOADON (MAHD)
);
GO


INSERT INTO KHACHHANG (TENKHACH, DIACHI, SDT)
VALUES
	(N'Kho Hồ Chí Minh 1', N'Công Trường Lam Sơn, Quận 1, Thành phố Hồ Chí Minh', '1900636677'),
	(N'Kho Hồ Chí Minh 2', N'144 Xuân Thủy, Quận Cầu Giấy, Thành phố Hồ Chí Minh', '19008095'),
    (N'Kho Hà Nội 1', N'Số 58 Quốc Tử Giám, Văn Miếu, Đống Đa, Hà Nội', '1900545481'),
	(N'Kho Hà Nội 2', N'Số 18 Phan Bội Châu, Hoàn Kiếm, Hà Nội', '19001088'),
    (N'Kho Đà Nẵng', N'Phường Khương Đông, Quận Ngũ Hành Sơn, Đà Nẵng', '1900886877'),
    (N'Kho Nghệ An', N'Số 22 Trường Thi, TP. Vinh, Nghệ An', '19001031'),
    (N'Kho Cần Thơ', N' 46 Hai Bà Trưng, phường An Bình, quận Ninh Kiều, Cần Thơ', '1900232345'),
    (N'Kho Huế', N'Số 2 Thái Phiên, Phường Hiệp Hòa, Thành phố Huế, Thừa Thiên Huế', '1900545411'),
    (N'Kho Bình Dương', N'KCN Việt Nam - Singapore, Thị xã Thuận An, Bình Dương', '19001221'),
    (N'Kho Thái Nguyên', N'Phường Tân Lập, thành phố Thái Nguyên, tỉnh Thái Nguyên', '19002828'),

    (N'Công Ty Xây Dựng Thiên Hạ', N'Q. 5, TP. HCM', '0901234567'),
    (N'Công Ty Kiến Trúc Xanh', N'Q. 12, TP. HCM', '0912345678'),
    (N'Công Ty Thiết Kế Phong Cách Mới', N'Q. Bình Thạnh, TP. HCM', '0923456789'),
    (N'Công Ty CP Xây Dựng Hà Tiên', N'Q. Hóc Môn, TP. HCM', '0934567890'),
    (N'Công Ty TNHH Thương Mại Green Tech', N'Q. Hoàn Kiếm, Hà Nội', '0945678901'),
    (N'Công Ty CP Thiết Kế Ngoại Thất', N'37 Đường Nguyễn Du, TP. Vũng Tàu', '0956789012'),
    (N'Công Ty CP Xây Dựng Ngọc Long', N'222 Đường Lạc Long Quân,TP. Đà Nẵng', '0967890123'),
    (N'Công Ty TNHH Kiến Trúc Kình Ba', N'654 Đường Lương Thế Vinh, TP. Vinh', '0978901234'),
    (N'Công Ty Building Future', N'31 QL62 , TP. Tân An, Long An', '0989012345'),
    (N'Công Ty CP VLXD Đào Nguyên', N'Q. Tân Bình, TP. HCM', '0990123456'),
	(N'Công Ty VLXD Vĩnh Cường',N'P. An Phú, Q.2, TPHCM','0971356662'),
	(N'Công Ty TNHH VLXD Quế Đông',N'P. Thạnh Xuân, Q.12, TPHCM','0997274652'),
	(N'Công Ty Cổ Phần Vicostone',N'Thạch Hòa, Thạch Thất, Hà Nội','18006766'),
	(N'Tổng Công Ty Viglacera - CTCP',N'Số 1 Đại lộ Thăng Long, Hà Nội','35536660'),
	(N'Công Ty Cổ Phần Eurowindow',N'Số 02 Tôn Thất Tùng,Q. Đống Đa, Hà Nội','37474777'),
	(N'Công Ty TNHH Siam City Cement',N'Q. 4, TP. HCM','02873017018'),
	(N'Công Ty Cổ Phần Gỗ An Cường',N'P. Thái Hòa, TX. Tân Uyên, Tỉnh Bình Dương','19006944'),
	(N'Công Ty CP Vicem VLXD Đà Nẵng',N'Hoà Hiệp Nam, Liên Chiểu, Đà Nẵng','02363707814'),
	(N'Công Ty Cp VLXD Thừa Thiên Huế',N'Xuân Phú, TP. Huế, Tỉnh Thừa Thiên Huế','02343823080'),
	(N'Công Ty Cổ Phần Xi Măng Tây Đô',N'Q. Ninh Kiều, TP. Cần Thơ','07103839045');

GO


INSERT INTO LOAIHANG (TENLOAI, DVT) VALUES
	(N'Xi Măng', N'Bao'),
	(N'Thép', N'Cây'),
	(N'Cát', N'M3'),
	(N'Gạch', N'Viên'),
	(N'Sắt', N'Cây'),
	(N'Sàn', N'Vỉ'),
	(N'Tường', N'M2'),
	(N'Trần', N'M2'),
	(N'Ngoại Thất', N'Bộ'),
	(N'Nội Thất', N'Bộ');
GO

INSERT INTO NHACUNGCAP (TENNCC, DIACHI, SDT) VALUES
	(N'Công ty CP SX TM VLXD Sài Gòn',N'P. Tây Thạnh, Q. Tân Phú, TP. HCM','0909789888'),
	(N'Công ty Song Phương - Bảo Hợp Tín',N'P. Hiệp Thạnh, Q. Tân Phú, TP. HCM','0944414797'),
	(N'Công ty Vina Built',N'P. 10, Q. Tân Bình, TP.HCM','0987447766'),
	(N'Công ty CP Hòa Phát, tập đoàn Hòa Phát',N'P. Nguyễn Du, Q. Hai Bà Trưng, Hà Nội','02462848666'),
	(N'Công ty CP Tập đoàn Hoa Sen',N'P. 10, Q. Phú Nhuận, TP. HCM','18001515'),
	(N'Công ty CP An Cường',N'P. Thái Hòa, TX. Tân Uyên, Tỉnh Bình Dương','19006944'),
	(N'Công ty CP Bình Minh',N'P. 9, Q.6, TP. HCM','02839690973'),
	(N'Công ty CP Hà Tiên 1',N'Cầu Kho, Q.1, TP. HCM','02838368363'),
	(N'Công ty TNHH Thương Mại Green Tech',N'P. An Khánh, TP. Thủ Đức, TP. HCM','0972699926'),
	(N'Công ty TNHH Nam Tiền Phong',N'P. Tam Phú, TP. Thủ Đức, Tp. HCM','0859737888');
GO


INSERT INTO SANPHAM (MALH, MANCC, TENSP, GIA)
VALUES
    (1, 1, N'Xi măng Hà Tiên', 200000),
    (2, 2, N'Thép xây dựng chịu lực', 250000),
    (3, 3, N'Cát xây dựng sạch', 120000),
    (4, 4, N'Gạch vuông', 5000),
    (5, 5, N'Sắt cường độ cao', 80000),
    (6, 6, N'Sàn gỗ công nghiệp', 350000),
    (7, 7, N'Gạch lát tường cao cấp', 200000),
    (8, 8, N'Trần gỗ', 300000),
    (9, 9, N'Bộ ngoại thất thiên nhiên', 700000),
    (10, 10, N'Bộ nội thất sang trọng', 500000),
    (1, 1, N'Xi măng Holcim', 110000),
    (2, 2, N'Thép ống dẹp', 800000),
    (3, 3, N'Cát mịn', 130000),
    (4, 4, N'Gạch ống', 4000),
    (5, 5, N'Sắt tròn', 85000),
    (6, 6, N'Sàn gạch men', 380000),
    (7, 7, N'Gạch giả gỗ', 220000),
    (8, 8, N'Trần nhựa PVC', 320000),
    (9, 9, N'Bộ ngoại thất hiện đại', 690000),
    (10, 10, N'Bộ nội thất hiện đại', 520000),
    (1, 1, N'Xi măng COTEC', 160000),
    (2, 2, N'Thép không gỉ', 270000),
    (3, 3, N'Cát cô đặc', 150000),
    (4, 4, N'Gạch tàu', 5500),
    (5, 5, N'Sắt thép cây', 55000),
    (6, 6, N'Sàn đá', 250000),
    (7, 7, N'Gạch lát tường bóng kính', 130000),
    (8, 8, N'Trần thạch cao', 440000),
    (9, 9, N'Bộ ngoại thất cổ kính', 1190000),
    (10, 10, N'Bộ nội thất cổ kính', 830000);
GO


INSERT INTO KHOHANG (TENKHOHANG, DIACHI,SDTQUANLY)
VALUES
    (N'Kho Hồ Chí Minh 1', N'Công Trường Lam Sơn, Quận 1, Thành phố Hồ Chí Minh', '1900636677'),
	(N'Kho Hồ Chí Minh 2', N'144 Xuân Thủy, Quận Cầu Giấy, Thành phố Hồ Chí Minh', '19008095'),
    (N'Kho Hà Nội 1', N'Số 58 Quốc Tử Giám, Văn Miếu, Đống Đa, Hà Nội', '1900545481'),
	(N'Kho Hà Nội 2', N'Số 18 Phan Bội Châu, Hoàn Kiếm, Hà Nội', '19001088'),
    (N'Kho Đà Nẵng', N'Phường Khương Đông, Quận Ngũ Hành Sơn, Đà Nẵng', '1900886877'),
    (N'Kho Nghệ An', N'Số 22 Trường Thi, TP. Vinh, Nghệ An', '19001031'),
    (N'Kho Cần Thơ', N' 46 Hai Bà Trưng, phường An Bình, quận Ninh Kiều, Cần Thơ', '1900232345'),
    (N'Kho Huế', N'Số 2 Thái Phiên, Phường Hiệp Hòa, Thành phố Huế, Thừa Thiên Huế', '1900545411'),
    (N'Kho Bình Dương', N'KCN Việt Nam - Singapore, Thị xã Thuận An, Bình Dương', '19001221'),
    (N'Kho Thái Nguyên', N'Phường Tân Lập, thành phố Thái Nguyên, tỉnh Thái Nguyên', '19002828');
GO


INSERT INTO KHOHANGCHITIET (MAKHO, MASP, SOLUONG)
VALUES
    (1, 7, 80),
    (1, 4, 95),
    (1, 9, 72),
    (1, 1, 90),
    (1, 2, 105),
    (1, 3, 75),
    (1, 5, 80),
    (1, 10, 95),
    (1, 8, 70),
    (1, 6, 85),
    (1, 15, 120),
    (1, 27, 75),
    (1, 20, 80),
    (1, 12, 100),
    (1, 17, 95),
    (1, 25, 85),
    (1, 11, 75),
    (1, 19, 90),
    (1, 16, 100),
    (1, 26, 80),

    (2, 22, 85),
    (2, 29, 70),
    (2, 14, 95),
    (2, 6, 80),
    (2, 28, 90),
    (2, 3, 105),
    (2, 26, 75),
    (2, 21, 80),
    (2, 24, 95),
    (2, 10, 70),
    (2, 13, 85),
    (2, 30, 120),
    (2, 1, 75),
    (2, 8, 80),
    (2, 4, 100),
    (2, 5, 95),
    (2, 7, 85),
    (2, 9, 75),
    (2, 2, 90),
    (2, 18, 100),

    (3, 19, 80),
    (3, 25, 95),
    (3, 23, 72),
    (3, 30, 90),
    (3, 26, 105),
    (3, 15, 75),
    (3, 6, 80),
    (3, 16, 95),
    (3, 14, 70),
    (3, 17, 85),
    (3, 27, 120),
    (3, 9, 75),
    (3, 7, 80),
    (3, 3, 100),
    (3, 1, 95),
    (3, 18, 85),
    (3, 10, 75),
    (3, 11, 90),
    (3, 2, 100),
    (3, 4, 80),

    (4, 20, 85),
    (4, 28, 70),
    (4, 13, 95),
    (4, 7, 80),
    (4, 8, 90),
    (4, 12, 105),
    (4, 1, 75),
    (4, 29, 80),
    (4, 24, 95),
    (4, 6, 70),
    (4, 2, 85),
    (4, 21, 120),
    (4, 26, 75),
    (4, 5, 80),
    (4, 9, 100),
    (4, 3, 95),
    (4, 4, 85),
    (4, 11, 75),
    (4, 10, 90),
    (4, 16, 100),

    (5, 3, 80),
    (5, 10, 95),
    (5, 5, 72),
    (5, 18, 90),
    (5, 15, 105),
    (5, 8, 75),
    (5, 4, 80),
    (5, 12, 95),
    (5, 1, 70),
    (5, 7, 85),
    (5, 2, 120),
    (5, 9, 75),
    (5, 11, 80),
    (5, 6, 100),
    (5, 14, 95),
    (5, 16, 85),
    (5, 17, 75),
    (5, 13, 90),
    (5, 19, 100),
    (5, 20, 80),

    (6, 23, 85),
    (6, 29, 70),
    (6, 25, 95),
    (6, 24, 80),
    (6, 30, 90),
    (6, 21, 105),
    (6, 22, 75),
    (6, 26, 80),
    (6, 27, 95),
    (6, 28, 70),
    (6, 1, 85),
    (6, 2, 120),
    (6, 3, 75),
    (6, 4, 80),
    (6, 5, 100),
    (6, 6, 95),
    (6, 7, 85),
    (6, 8, 75),
    (6, 9, 90),
    (6, 10, 100),

    (7, 11, 80),
    (7, 12, 95),
    (7, 13, 72),
    (7, 14, 90),
    (7, 15, 105),
    (7, 16, 75),
    (7, 17, 80),
    (7, 18, 95),
    (7, 19, 70),
    (7, 20, 85),
    (7, 21, 120),
    (7, 22, 75),
    (7, 23, 80),
    (7, 24, 100),
    (7, 25, 95),
    (7, 26, 85),
    (7, 27, 75),
    (7, 28, 90),
    (7, 29, 100),
    (7, 30, 80),

    (8, 1, 85),
    (8, 2, 70),
    (8, 3, 95),
    (8, 4, 80),
    (8, 5, 90),
    (8, 6, 105),
    (8, 7, 75),
    (8, 8, 80),
    (8, 9, 95),
    (8, 10, 70),
    (8, 11, 85),
    (8, 12, 120),
    (8, 13, 75),
    (8, 14, 80),
    (8, 15, 100),
    (8, 16, 95),
    (8, 17, 85),
    (8, 18, 75),
    (8, 19, 90),
    (8, 20, 100),

    (9, 21, 80),
    (9, 22, 95),
    (9, 23, 72),
    (9, 24, 90),
    (9, 25, 105),
    (9, 26, 75),
    (9, 27, 80),
    (9, 28, 95),
    (9, 29, 70),
    (9, 30, 85),
    (9, 1, 120),
    (9, 2, 75),
    (9, 3, 80),
    (9, 4, 100),
    (9, 5, 95),
    (9, 6, 85),
    (9, 7, 75),
    (9, 8, 90),
    (9, 9, 100),
    (9, 10, 80),

    (10, 11, 85),
    (10, 12, 70),
    (10, 13, 95),
    (10, 14, 80),
    (10, 15, 90),
    (10, 16, 105),
    (10, 17, 75),
    (10, 18, 80),
    (10, 19, 95),
    (10, 20, 70),
    (10, 21, 85),
    (10, 22, 120),
    (10, 23, 75),
    (10, 24, 80),
    (10, 25, 100),
    (10, 26, 95),
    (10, 27, 85),
    (10, 28, 75),
    (10, 29, 90),
    (10, 30, 100);
GO


INSERT INTO HOADON (MAKHACH, MAKHO, NGAYLAPHOADON, LOAIHOADON, TRANGTHAI)
VALUES
  (1, 9, '2023-05-09', N'Nhập', 'Returned'),
  (20, 10, '2023-05-10', N'Xuất', 'Success'),
  (2, 2, '2023-05-11', N'Nhập', 'Pending'),
  (12, 3, '2023-05-12', N'Xuất', 'Delivering'),
  (3, 4, '2023-05-13', N'Nhập', 'Cancelled'),
  (14, 5, '2023-05-14', N'Xuất', 'Returned'),
  (5, 6, '2023-05-15', N'Nhập', 'Success'),
  (16, 7, '2023-05-16', N'Xuất', 'Pending'),
  (7, 8, '2023-05-17', N'Nhập', 'Delivering'),
  (18, 9, '2023-05-18', N'Xuất', 'Cancelled'),
  (9, 10, '2023-05-19', N'Nhập', 'Returned'),
  (20, 1, '2023-05-20', N'Xuất', 'Success'),
  (1, 3, '2023-05-21', N'Nhập', 'Pending'),
  (12, 4, '2023-05-22', N'Xuất', 'Delivering'),
  (3, 5, '2023-05-23', N'Nhập', 'Cancelled'),
  (14, 6, '2023-05-24', N'Xuất', 'Returned'),
  (5, 7, '2023-05-25', N'Nhập', 'Success'),
  (16, 8, '2023-05-26', N'Xuất', 'Pending'),
  (7, 9, '2023-05-27', N'Nhập', 'Delivering'),
  (18, 10, '2023-05-28', N'Xuất', 'Cancelled'),
  (9, 1, '2023-05-29', N'Nhập', 'Returned'),
  (20, 2, '2023-05-30', N'Xuất', 'Success'),
  (1, 1, '2023-06-01', N'Nhập', 'Pending'),
  (12, 2, '2023-06-02', N'Xuất', 'Delivering'),
  (3, 3, '2023-06-03', N'Nhập', 'Cancelled'),
  (14, 4, '2023-06-04', N'Xuất', 'Returned'),
  (5, 5, '2023-06-05', N'Nhập', 'Success'),
  (16, 6, '2023-06-06', N'Xuất', 'Pending'),
  (7, 7, '2023-06-07', N'Nhập', 'Delivering'),
  (18, 8, '2023-06-08', N'Xuất', 'Cancelled');
GO

INSERT INTO HOADONCHITIET (MASP, MAHD, SOLUONG) 
VALUES
	(3, 15, 22),
	(10, 4, 35),
	(25, 17, 11),
	(10, 29, 26),
	(4, 12, 19),
	(5, 1, 12),
	(27, 11, 21),
	(7, 26, 10),
	(9, 23, 16),
	(26, 14, 18),
	(13, 3, 39),
	(15, 5, 31),
	(30, 20, 29),
	(20, 6, 27),
	(11, 21, 20),
	(12, 2, 8),
	(2, 9, 13),
	(16, 18, 17),
	(10, 28, 30),
	(8, 13, 7),
	(9, 24, 33),
	(24, 19, 37),
	(1, 7, 23),
	(4, 25, 34),
	(6, 16, 6),
	(21, 27, 24),
	(4, 22, 32),
	(2, 30, 15),
	(28, 26, 10),
	(20, 10, 29),
	(25, 23, 16),
	(9, 6, 18),
	(13, 9, 39),
	(30, 11, 38),
	(16, 12, 31),
	(3, 27, 29),
	(29, 3, 27),
	(19, 15, 20),
	(10, 16, 8),
	(14, 5, 13),
	(5, 14, 17),
	(7, 24, 15),
	(7, 21, 35),
	(11, 1, 32),
	(12, 7, 39),
	(2, 4, 31),
	(6, 18, 20),
	(28, 8, 33),
	(15, 13, 37),
	(30, 19, 22),
	(20, 25, 14),
	(1, 26, 33),
	(4, 10, 16),
	(6, 27, 6),
	(21, 23, 24),
	(17, 6, 17),
	(22, 13, 25),
	(29, 28, 30),
	(25, 9, 7),
	(9, 11, 33),
	(3, 12, 37),
	(11, 15, 30);	
GO


-- TRIGGER UPDATE NHACUNGCAP
CREATE OR ALTER TRIGGER trg_NHACUNGCAP_Update
ON NHACUNGCAP
AFTER UPDATE
AS
BEGIN
    IF UPDATE(FLAG)
    BEGIN
        UPDATE SANPHAM
        SET MANCC = NULL
        WHERE MANCC IN (SELECT MANCC FROM deleted)
    END
END
GO


-- TRIGGER SANPHAM
CREATE OR ALTER TRIGGER trg_SANPHAM_insert
ON SANPHAM
INSTEAD OF INSERT
AS
BEGIN
	DECLARE @maLh INT, @maNcc INT, @tenSp NVARCHAR(30), @gia INT

	SET @maLh = (SELECT MALH FROM inserted)
	SET @maNcc = (SELECT MANCC FROM inserted)
	SET @tenSp = (SELECT TENSP FROM inserted)
	PRINT @tenSp
	SET @gia = (SELECT GIA FROM inserted)


    IF @maNcc = 0
    BEGIN
        SET @maNcc = NULL
    END

	INSERT INTO SANPHAM (MALH, MANCC, TENSP, GIA)
	VALUES
		(@maLh, @maNcc, @tenSp, @gia)
END
GO

-- TRIGGER HOADON
CREATE OR ALTER TRIGGER trg_HOADON_delete
ON HOADON
INSTEAD OF DELETE
AS
BEGIN
	DECLARE @maHd INT = (SELECT MAHD FROM deleted)

	DELETE HOADONCHITIET
	WHERE MAHD = @maHd

	DELETE HOADON
	WHERE MAHD = @maHd
END
GO



/*
EXEC sp_MSforeachtable @command1 = "DROP TABLE ?"

*/
SELECT  * FROM HOADON ORDER BY MAHD DESC