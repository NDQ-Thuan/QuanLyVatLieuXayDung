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


--MAIN
CREATE TABLE KHACHHANG (
    MAKHACH INT IDENTITY(1,1) PRIMARY KEY,
    TENKHACH NVARCHAR(50) NOT NULL,
    DIACHI NVARCHAR(100) NOT NULL,
    SDT VARCHAR(15) NOT NULL
);
GO


CREATE TABLE NHACUNGCAP (
    MANCC INT IDENTITY(1,1) PRIMARY KEY,
    TENNCC NVARCHAR(50) NOT NULL,
    DIACHI NVARCHAR(100) NOT NULL,
    SDT VARCHAR(15) NOT NULL,
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
    MANCC INT NOT NULL,
	TENSP NVARCHAR(50) NOT NULL,
    GIA INT NOT NULL,
    FOREIGN KEY (MALH) REFERENCES LOAIHANG(MALH),
    FOREIGN KEY (MANCC) REFERENCES NHACUNGCAP(MANCC)
);
GO


CREATE TABLE KHOHANG (
    MAKHO INT IDENTITY(1,1) PRIMARY KEY,
	TENKHOHANG NVARCHAR(50) NOT NULL,
    DIACHI NVARCHAR(200) NULL,
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



INSERT INTO KHOHANGCHITIET(MAKHO,MASP,SOLUONG)
VALUES
	(10, 25, 4523),
	(8, 3, 6714),
	(4, 28, 2181),
	(7, 12, 3467),
	(3, 15, 9321),
	(6, 8, 9876),
	(5, 9, 7825),
	(9, 19, 3498),
	(6, 23, 2567),
	(7, 2, 5324),
	(1, 27, 5690),
	(10, 26, 3615),
	(7, 29, 7622),
	(9, 21, 9867),
	(5, 4, 4321),
	(2, 13, 6276),
	(9, 8, 8921),
	(3, 11, 5265),
	(4, 7, 4567),
	(8, 17, 6875),
	(4, 19, 8901),
	(10, 20, 6425),
	(1, 5, 5700),
	(5, 16, 8324),
	(1, 23, 3465),
	(7, 1, 4532),
	(9, 21, 8125),
	(2, 10, 6278),
	(1, 30, 1201),
	(6, 19, 5467),
	(10, 3, 2495),
	(3, 25, 4326),
	(2, 4, 2567),
	(5, 15, 7491),
	(8, 6, 4367),
	(1, 18, 5605),
	(10, 13, 3572),
	(7, 26, 8025),
	(9, 9, 1250),
	(6, 22, 8643),
	(2, 17, 2478),
	(5, 12, 7263),
	(4, 24, 3456),
	(1, 20, 5800),
	(3, 2, 8265),
	(8, 14, 6876),
	(10, 16, 4632),
	(6, 28, 6843),
	(9, 5, 7211),
	(7, 18, 2398),
	(4, 20, 8934),
	(3, 7, 6265),
	(5, 24, 7934),
	(1, 3, 5100),
	(10, 7, 1525),
	(2, 10, 3678),
	(8, 11, 7875),
	(6, 9, 6643),
	(9, 29, 9625),
	(7, 13, 7891),
	(1, 4, 5200),

	(9, 4, 7157),
	(6, 24, 5827),
	(4, 15, 5132),
	(5, 29, 6561),
	(2, 5, 7076),
	(5, 9, 6066),
	(9, 21, 8694),
	(2, 23, 7819),
	(8, 10, 8588),
	(5, 14, 5386),
	(1, 28, 5255),
	(2, 27, 8584),
	(10, 20, 7629),
	(5, 11, 5898),
	(2, 4, 8265),
	(10, 15, 5523),
	(6, 10, 7227),
	(2, 3, 8035),
	(10, 26, 8006),
	(3, 30, 7150),
	(7, 16, 7456),
	(8, 19, 6444),
	(9, 7, 7791),
	(1, 28, 5544),
	(2, 10, 5733),
	(3, 8, 7914),
	(9, 28, 7976),
	(3, 16, 5179),
	(5, 26, 7790),
	(6, 12, 7435),
	(10, 18, 7009),
	(7, 27, 7162),
	(6, 17, 8268),
	(10, 2, 7873),
	(8, 23, 6562),
	(7, 28, 5444),
	(3, 21, 6487),
	(4, 8, 7081),
	(8, 9, 8433),
	(9, 18, 6093),
	(4, 22, 7312),
	(7, 14, 8391),
	(1, 27, 8082),
	(6, 1, 5189),
	(10, 26, 6059),
	(4, 13, 6405),
	(9, 8, 7522),
	(5, 4, 8570),
	(2, 30, 6775),
	(7, 9, 7062),
	(8, 24, 7980),
	(5, 10, 8626),
	(7, 17, 6422),
	(4, 29, 5563),
	(6, 14, 6064),
	(3, 21, 5410),
	(9, 3, 5702),
	(10, 5, 7516),
	(1, 15, 6916),
	(2, 26, 5611),
	(3, 1, 6909),
	(7, 20, 6070),
	(9, 13, 7684),
	(6, 25, 6105),
	(10, 11, 5772),
	(3, 6, 6335),
	(1, 27, 5925),
	(8, 22, 7974),
	(7, 5, 5906),
	(4, 29, 5585),
	(5, 12, 7605),
	(6, 25, 5761),
	(1, 17, 5386),
	(9, 21, 5639),
	(10, 13, 6595),
	(8, 4, 5570),
	(6, 16, 5537),
	(2, 26, 6327),
	(4, 19, 8125),
	(1, 8, 5909),
	(9, 2, 6876),
	(8, 30, 5887),
	(3, 27, 8225),
	(7, 5, 7991),
	(2, 15, 6121),
	(10, 1, 7910),
	(6, 3, 6102),
	(1, 25, 5464),
	(5, 6, 8542),
	(2, 23, 5202),
	(10, 9, 5001),
	(6, 14, 7656),
	(1, 18, 5575),
	(4, 7, 6385),
	(8, 28, 8277),
	(5, 11, 6091),
	(3, 22, 6859),
	(7, 30, 6741),
	(9, 16, 5472),
	(1, 19, 8680),
	(2, 29, 6180),
	(4, 25, 5053),
	(5, 16, 5704),
	(9, 20, 6170),
	(6, 24, 6521),
	(8, 14, 7869),
	(2, 3, 6998),
	(5, 27, 5809),
	(9, 9, 6856),
	(10, 17, 6517),
	(4, 7, 7674),
	(8, 26, 7356),
	(7, 13, 5636),
	(6, 23, 7714),
	(1, 10, 5049),
	(3, 18, 5707),
	(4, 21, 7761),
	(5, 2, 6734),
	(9, 8, 6716),
	(7, 16, 7273),
	(2, 29, 7970),
	(6, 11, 5862),
	(10, 22, 8112),
	(4, 3, 5835),
	(1, 5, 6187),
	(7, 12, 6134),
	(8, 25, 5764),
	(5, 20, 6875),
	(3, 29, 6012),
	(2, 1, 8083),
	(6, 10, 5361),
	(9, 30, 5725),
	(10, 26, 8123),
	(7, 15, 5621),
	(4, 19, 5942),
	(8, 9, 6111),
	(5, 28, 5512),
	(2, 24, 6788),
	(9, 7, 5646),
	(6, 16, 5072),
	(10, 5, 5679),
	(3, 27, 5823),
	(1, 13, 5325),
	(5, 21, 7542),
	(4, 11, 7939),
	(3, 22, 6534),
	(10, 6, 7923),
	(8, 26, 7034),
	(7, 17, 7444),
	(1, 28, 7544),
	(4, 2, 7915),
	(6, 13, 8243),
	(9, 19, 7190),
	(2, 15, 5252),
	(10, 7, 7703),
	(5, 29, 5810),
	(7, 8, 6182),
	(8, 23, 8231),
	(2, 18, 6504),
	(3, 14, 6542),
	(6, 27, 6528),
	(9, 1, 5923),
	(1, 10, 5083),
	(5, 19, 7137),
	(8, 30, 8157),
	(10, 4, 6616),
	(2, 24, 5865),
	(7, 13, 7997),
	(9, 16, 8217),
	(4, 6, 5377),
	(6, 21, 5698),
	(5, 3, 7689),
	(3, 12, 6356),
	(1, 25, 5983),
	(8, 11, 7835),
	(2, 28, 7151),
	(7, 17, 5906),
	(9, 9, 5773),
	(4, 22, 7058),
	(6, 5, 6184),
	(3, 30, 7380),
	(10, 14, 5835),
	(1, 18, 5812),
	(5, 8, 6903),
	(2, 29, 7239),
	(7, 4, 7063),
	(8, 27, 6073),
	(3, 21, 6467),
	(6, 12, 7105),
	(9, 16, 5002),
	(1, 27, 6333),
	(10, 10, 7406),
	(4, 1, 7141),
	(8, 23, 6785),
	(9, 6, 5917),
	(5, 19, 5439),
	(1, 14, 7150),
	(7, 28, 6572),
	(4, 30, 5043),
	(2, 9, 6186),
	(6, 22, 5039),
	(3, 7, 5256),
	(5, 25, 6876),
	(10, 16, 5762),
	(8, 19, 6062),
	(7, 9, 6619),
	(9, 27, 8295),
	(1, 8, 5705),
	(3, 21, 6527),
	(4, 29, 7759),
	(6, 14, 8213),
	(10, 2, 7278),
	(2, 16, 8156),
	(5, 11, 6216),
	(8, 30, 7225),
	(9, 7, 7723),
	(7, 13, 5514),
	(1, 27, 5655),
	(6, 1, 7686),
	(10, 26, 7921),
	(8, 9, 7821),
	(4, 21, 7689),
	(2, 29, 7978),
	(7, 20, 5610),
	(5, 12, 8062),
	(6, 30, 8210),
	(1, 17, 6165),
	(9, 21, 5533);

GO

INSERT INTO HOADON (MAKHACH,MAKHO, NGAYLAPHOADON, LOAIHOADON, TRANGTHAI)
VALUES
	(1,9, '2023-01-01', N'Nhập', 'Pending'),
    (2,10, '2023-01-11', N'Xuất', 'Pending'),
    (3,1, '2023-01-21', N'Nhập', 'Delivered'),
    (4,2, '2023-01-02', N'Xuất', 'Cancelled'),
    (5,3, '2023-01-12', N'Nhập', 'Returned'),
    (6,4, '2023-01-22', N'Xuất', 'Pending'),
    (7,5, '2023-01-03', N'Nhập', 'Delivering'),
    (8,6, '2023-01-13', N'Xuất', 'Delivered'),
    (9,7, '2023-01-23', N'Nhập', 'Cancelled'),
    (10,8, '2023-1-30', N'Xuất', 'Returned'),

    (11,10, '2023-02-04', N'Nhập', 'Pending'),
    (12,9, '2023-02-14', N'Xuất', 'Delivering'),
    (13,8, '2023-02-24', N'Nhập', 'Delivered'),
    (14,7, '2023-02-05', N'Xuất', 'Cancelled'),
    (15,6, '2023-02-15', N'Nhập', 'Returned'),
    (16,5, '2023-02-25', N'Xuất', 'Pending'),
    (17,4, '2023-02-06', N'Nhập', 'Delivering'),
    (18,3, '2023-02-16', N'Xuất', 'Delivered'),
    (19,2, '2023-02-26', N'Nhập', 'Cancelled'),
    (20,1, '2023-02-28', N'Xuất', 'Returned'),

    (20,3,'2023-03-07', N'Nhập', 'Pending'),
    (19,5, '2023-03-17', N'Xuất', 'Delivering'),
    (18,7, '2023-03-27', N'Nhập', 'Delivered'),
    (17,9, '2023-03-08', N'Xuất', 'Cancelled'),
    (16,1, '2023-03-18', N'Nhập', 'Returned'),
    (15,2, '2023-03-28', N'Xuất', 'Returned'),
    (14,4, '2023-03-09', N'Nhập', 'Delivering'),
    (13,6, '2023-03-19', N'Xuất', 'Delivered'),
    (12,8, '2023-03-29', N'Nhập', 'Cancelled'),
    (11,10, '2023-03-30', N'Xuất', 'Pending'),

    (10,5, '2023-04-03', N'Nhập', 'Pending'),
    (9,7, '2023-04-03', N'Xuất', 'Delivering'),
    (8,9, '2023-04-12', N'Nhập', 'Delivered'),
    (7,10, '2023-04-15', N'Xuất', 'Pending'),
    (6,1, '2023-04-17', N'Nhập', 'Returned'),
    (5,2, '2023-04-19', N'Xuất', 'Cancelled'),
    (4,3, '2023-04-25', N'Nhập', 'Delivering'),
    (3,8, '2023-04-27', N'Xuất', 'Delivered'),
    (2,6, '2023-04-29', N'Nhập', 'Cancelled'),
    (1,4, '2023-04-30', N'Xuất', 'Returned'),

    (2,1, '2023-05-01', N'Nhập', 'Pending'),
    (4,3, '2023-05-03', N'Xuất', 'Delivering'),
    (6,4, '2023-05-07', N'Xuất', 'Delivered'),
    (8,5, '2023-05-10', N'Xuất', 'Delivered'),
    (10,2, '2023-05-14', N'Nhập', 'Returned'),
    (12,6, '2023-05-18', N'Xuất', 'Delivering'),
    (14,10, '2023-05-19', N'Nhập', 'Delivering'),
    (16,8, '2023-05-20', N'Xuất', 'Pending'),
    (18,7, '2023-05-22', N'Nhập', 'Cancelled'),
    (20,8, '2023-05-25', N'Xuất', 'Delivered'),

    (1,9, '2023-06-02', N'Nhập', 'Pending'),
    (3,8, '2023-06-03', N'Xuất', 'Pending'),
    (5,7, '2023-06-04', N'Nhập', 'Delivered'),
    (7,6, '2023-06-05', N'Xuất', 'Pending'),
    (9,5, '2023-06-05', N'Nhập', 'Returned'),
    (11,4, '2023-06-07', N'Xuất', 'Pending'),
    (13,3, '2023-06-07', N'Nhập', 'Delivering'),
    (15,2, '2023-06-09', N'Xuất', 'Delivered'),
    (17,10, '2023-06-10', N'Nhập', 'Cancelled'),
    (19,1, '2023-06-15', N'Xuất', 'Pending');


INSERT INTO HOADONCHITIET(MASP, MAHD, SOLUONG)
VALUES
	(24, 1, 96),
	(27, 2, 214),
	(11, 3, 105),
	(14, 4, 22),
	(2, 5, 71),
	(26, 6, 132),
	(5, 7, 67),
	(13, 8, 98),
	(8, 9, 191),
	(1, 10, 295),
	(18, 11, 160),
	(29, 12, 225),
	(19, 13, 8),
	(20, 14, 288),
	(6, 15, 60),
	(9, 16, 155),
	(12, 17, 263),
	(10, 18, 80),
	(17, 19, 248),
	(23, 20, 136),
	(28, 21, 252),
	(4, 22, 206),
	(16, 23, 218),
	(22, 24, 82),
	(7, 25, 51),
	(21, 26, 47),
	(15, 27, 180),
	(25, 28, 194),
	(3, 29, 276),
	(30, 30, 273),
	(3, 31, 196),
	(25, 32, 231),
	(24, 33, 270),
	(11, 34, 220),
	(18, 35, 122),
	(10, 36, 53),
	(14, 37, 23),
	(28, 38, 246),
	(9, 39, 38),
	(27, 40, 92),
	(5, 41, 207),
	(23, 42, 233),
	(1, 43, 162),
	(21, 44, 209),
	(16, 45, 189),
	(26, 46, 268),
	(20, 47, 166),
	(8, 48, 268),
	(29, 49, 165),
	(15, 50, 190),
	(7, 51, 278),
	(22, 52, 136),
	(4, 53, 60),
	(13, 54, 13),
	(12, 55, 284),
	(19, 56, 156),
	(2, 57, 220),
	(30, 58, 98),
	(6, 59, 175),
	(17, 60, 39),

	(9, 1, 96),
	(12, 2, 214),
	(20, 3, 105),
	(5, 4, 22),
	(29, 5, 71),
	(22, 6, 132),
	(28, 7, 67),
	(13, 8, 98),
	(25, 9, 191),
	(8, 10, 295),
	(11, 11, 160),
	(2, 12, 225),
	(4, 13, 8),
	(18, 14, 288),
	(24, 15, 60),
	(23, 16, 155),
	(27, 17, 263),
	(12, 18, 80),
	(27, 19, 248),
	(1, 20, 136),
	(14, 21, 252),
	(7, 22, 206),
	(11, 23, 218),
	(14, 24, 82),
	(8, 25, 51),
	(23, 26, 47),
	(4, 27, 180),
	(28, 28, 194),
	(24, 29, 276),
	(28, 30, 273),
	(24, 31, 196),
	(28, 32, 231),
	(8, 33, 270),
	(9, 34, 220),
	(26, 35, 122),
	(30, 36, 53),
	(22, 37, 23),
	(14, 38, 246),
	(9, 39, 38),
	(9, 40, 92),
	(20, 41, 207),
	(8, 42, 233),
	(15, 43, 162),
	(14, 44, 209),
	(23, 45, 189),
	(15, 46, 268),
	(26, 47, 166),
	(2, 48, 268),
	(28, 49, 165),
	(18, 50, 190),
	(12, 51, 278),
	(10, 52, 136),
	(7, 53, 60),
	(13, 54, 13),
	(30, 55, 284),
	(19, 56, 156),
	(11, 57, 220),
	(19, 58, 98),
	(15, 59, 175),
	(17, 60, 39),

	(19, 1, 273),
	(7, 2, 214),
	(28, 3, 174),
	(16, 4, 22),
	(3, 5, 71),
	(9, 6, 132),
	(14, 7, 67),
	(26, 8, 98),
	(10, 9, 191),
	(28, 10, 300),
	(5, 11, 160),
	(18, 12, 225),
	(30, 13, 8),
	(1, 14, 288),
	(24, 15, 60),
	(22, 16, 155),
	(11, 17, 263),
	(15, 18, 80),
	(27, 19, 248),
	(2, 20, 136),
	(21, 21, 252),
	(6, 22, 206),
	(20, 23, 218),
	(13, 24, 82),
	(8, 25, 51),
	(23, 26, 47),
	(25, 27, 180),
	(17, 28, 194),
	(30, 29, 276),
	(4, 30, 273),
	(11, 31, 196),
	(29, 32, 231),
	(24, 33, 270),
	(19, 34, 220),
	(9, 35, 122),
	(16, 36, 53),
	(12, 37, 23),
	(26, 38, 246),
	(1, 39, 38),
	(5, 40, 92),
	(22, 41, 207),
	(27, 42, 233),
	(14, 43, 162),
	(3, 44, 209),
	(20, 45, 189),
	(10, 46, 268),
	(8, 47, 166),
	(13, 48, 268),
	(21, 49, 165),
	(25, 50, 190),
	(6, 51, 278),
	(17, 52, 136),
	(4, 53, 60),
	(29, 54, 13),
	(15, 55, 284),
	(12, 56, 156),
	(28, 57, 220),
	(2, 58, 98),
	(18, 59, 175),
	(7, 60, 39);

GO


-- TRIGGER DELETE HOADON
CREATE OR ALTER TRIGGER trg_HOADON_Delete
ON HOADON
INSTEAD OF DELETE
AS
BEGIN
    SET NOCOUNT ON;

    -- Delete related HOADONCHITIET rows
    DELETE FROM HOADONCHITIET
    WHERE MAHD IN (SELECT MAHD FROM deleted);

    -- Delete the HOADON rows
    DELETE FROM HOADON
    WHERE MAHD IN (SELECT MAHD FROM deleted);
END;
GO


-- TRIGGER DELETE KHACHHANG
CREATE TRIGGER trg_KHACHHANG_Delete
ON KHACHHANG
INSTEAD OF DELETE
AS
BEGIN
    SET NOCOUNT ON;

    -- Delete related HOADON rows
    DELETE FROM HOADON
    WHERE MAKHACH IN (SELECT MAKHACH FROM deleted);

    -- Delete the KHACHHANG row
    DELETE FROM KHACHHANG
    WHERE MAKHACH IN (SELECT MAKHACH FROM deleted);
END;
GO


-- TRIGGER DELETE SANPHAM
CREATE TRIGGER trg_SANPHAM_Delete
ON SANPHAM
INSTEAD OF DELETE
AS
BEGIN
    SET NOCOUNT ON;

    -- Delete related HOADONCHITIET rows
    DELETE FROM HOADONCHITIET
    WHERE MASP IN (SELECT MASP FROM deleted);

    -- Delete related KHOHANGCHITIET rows
    DELETE FROM KHOHANGCHITIET
    WHERE MASP IN (SELECT MASP FROM deleted);

	-- Delete the SANPHAM row
	DELETE FROM SANPHAM
    WHERE MASP IN (SELECT MASP FROM deleted);
END;
GO


-- TRIGGER DELETE NHACUNGCAP
CREATE TRIGGER trg_NHACUNGCAP_Delete
ON NHACUNGCAP
INSTEAD OF DELETE
AS
BEGIN
    SET NOCOUNT ON;

    -- Delete related SANPHAM rows
    DELETE FROM SANPHAM
    WHERE MANCC IN (SELECT MANCC FROM deleted);


    -- Delete the NHACUNGCAP row
    DELETE FROM NHACUNGCAP
    WHERE MANCC IN (SELECT MANCC FROM deleted);
END;
GO


-- TRIGGER INSERT KHOHANGCHITIET
CREATE OR ALTER TRIGGER CombineSOLUONG
ON KHOHANGCHITIET
AFTER INSERT
AS
BEGIN
    -- Update the existing rows with combined SOLUONG
    UPDATE KHOHANGCHITIET
    SET SOLUONG = kc.SOLUONG + ins.SOLUONG
    FROM KHOHANGCHITIET kc
    INNER JOIN inserted ins ON kc.MASP = ins.MASP AND kc.MAKHO = ins.MAKHO
    WHERE kc.MASP = ins.MASP AND kc.MAKHO = ins.MAKHO;
    
    -- Insert new rows if they don't exist already
    INSERT INTO KHOHANGCHITIET (MASP, MAKHO, SOLUONG)
    SELECT ins.MASP, ins.MAKHO, ins.SOLUONG
    FROM inserted ins
    WHERE NOT EXISTS (
        SELECT 1
        FROM KHOHANGCHITIET kc
        WHERE kc.MASP = ins.MASP AND kc.MAKHO = ins.MAKHO
    );
END;
GO


-- PROCEDURE HOADONCHITIET
CREATE OR ALTER PROCEDURE UpdateHOADONCHITIET
AS
BEGIN
    SET NOCOUNT ON;
    
    -- Update the existing rows with combined SOLUONG
    UPDATE hc1
    SET hc1.SOLUONG = hc1.SOLUONG + hc2.SOLUONG
    FROM HOADONCHITIET hc1
    INNER JOIN HOADONCHITIET hc2 ON hc1.MASP = hc2.MASP AND hc1.MAHD = hc2.MAHD
    WHERE hc1.MASP = hc2.MASP AND hc1.MAHD = hc2.MAHD
    AND hc1.MASP IN (
        SELECT MASP
        FROM HOADONCHITIET
        GROUP BY MASP, MAHD
        HAVING COUNT(*) > 1
    );
    
    -- Delete duplicate rows except for the one with the highest SOLUONG
    DELETE hc
    FROM HOADONCHITIET hc
    INNER JOIN (
        SELECT MASP, MAHD, MAX(SOLUONG) AS MaxSOLUONG
        FROM HOADONCHITIET
        GROUP BY MASP, MAHD
        HAVING COUNT(*) > 1
    ) dup ON hc.MASP = dup.MASP AND hc.MAHD = dup.MAHD
    WHERE hc.SOLUONG < dup.MaxSOLUONG;

	-- Delete duplicate rows except for the one with the smaller ID
	DELETE hc
    FROM HOADONCHITIET hc
    INNER JOIN (
        SELECT MASP, MAHD
        FROM HOADONCHITIET
        GROUP BY MASP, MAHD
        HAVING COUNT(*) > 1
    ) dup ON hc.MASP = dup.MASP AND hc.MAHD = dup.MAHD
    WHERE hc.MASP = dup.MASP AND hc.MAHD = dup.MAHD
END;
GO
EXEC UpdateHOADONCHITIET;
GO


-- PRODEDURE KHOHANGCHITIET
CREATE OR ALTER PROCEDURE UpdateKHOHANGCHITIET
AS
BEGIN
    SET NOCOUNT ON;
    
    -- Update the existing rows with combined SOLUONG
    UPDATE kc1
    SET kc1.SOLUONG = kc1.SOLUONG + kc2.SOLUONG
    FROM KHOHANGCHITIET kc1
    INNER JOIN KHOHANGCHITIET kc2 ON kc1.MASP = kc2.MASP AND kc1.MAKHO = kc2.MAKHO
    WHERE kc1.MASP = kc2.MASP AND kc1.MAKHO = kc2.MAKHO
    AND kc1.MASP IN (
        SELECT MASP
        FROM KHOHANGCHITIET
        GROUP BY MASP, MAKHO
        HAVING COUNT(*) > 1
    );
    
    -- Delete duplicate rows except for the one with the highest SOLUONG
    DELETE kc
    FROM KHOHANGCHITIET kc
    INNER JOIN (
        SELECT MASP, MAKHO, MAX(SOLUONG) AS MaxSOLUONG
        FROM KHOHANGCHITIET
        GROUP BY MASP, MAKHO
        HAVING COUNT(*) > 1
    ) dup ON kc.MASP = dup.MASP AND kc.MAKHO = dup.MAKHO
    WHERE kc.SOLUONG < dup.MaxSOLUONG;
END;
GO
EXEC UpdateKHOHANGCHITIET;
GO





/*
EXEC sp_MSforeachtable @command1 = "DROP TABLE ?"
*/

SELECT * FROM SANPHAM JOIN NHACUNGCAP ON SANPHAM.MANCC = NHACUNGCAP.MANCC