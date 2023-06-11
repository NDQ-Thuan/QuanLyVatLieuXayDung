﻿CREATE DATABASE QuanLyVatLieuXayDung;
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
    SDT VARCHAR(12) NOT NULL,
	FLAG BIT DEFAULT 0, -- Flag inactive
);
GO


CREATE TABLE NHACUNGCAP (
    MANCC INT IDENTITY(1,1) PRIMARY KEY,
    TENNCC NVARCHAR(50) NOT NULL,
    DIACHI NVARCHAR(100) NOT NULL,
    SDT VARCHAR(10) NOT NULL,	
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


INSERT INTO NHACUNGCAP (TENNCC, DIACHI, SDT)
VALUES
  (N'Công ty Xây dựng Thành Đạt', N'Số 10, Đường Hoàng Quốc Việt, Hà Nội', '0123456789'),
  (N'Nhà phân phối Vật liệu Xây dựng Hùng Thịnh', N'Trung tâm thương mại Vincom, Tp. Hồ Chí Minh', '0987654321'),
  (N'Công ty Cổ phần Vật liệu Xây dựng Hoàng Gia', N'Phố Huế, Thanh Hóa', '0369874521'),
  (N'Nhà cung cấp Vật liệu Xây dựng Bảo An', N'Ngõ 68, Đại Cồ Việt, Hà Nội', '0941234567'),
  (N'Công ty TNHH Thiết bị Xây dựng Đại Phát', N'Lô B7, KCN Phố Nối A, Hưng Yên', '0912345678'),
  (N'Nhà cung cấp Vật liệu Xây dựng Minh Tâm', N'Tổ 4, P. Tân Triều, Thanh Trì, Hà Nội', '0976543210'),
  (N'Công ty Cổ phần Xây dựng và Vật liệu Xanh', N'Nguyễn Văn Linh, Đà Nẵng', '0358749632'),
  (N'Nhà cung cấp Vật liệu Xây dựng Trường Giang', N'Số 15, Đường Bắc Hải, Quảng Ninh', '0862413975'),
  (N'Công ty TNHH Thương mại và Xây dựng Anh Quốc', N'Phố Lê Văn Thịnh, Nghệ An', '0932165874'),
  (N'Nhà phân phối Vật liệu Xây dựng Hiếu Hạnh', N'Đường Trần Phú, Tp. Hồ Chí Minh', '0918394756'),
  (N'Công ty Cổ phần Vật liệu Xây dựng Minh Châu', N'Nguyễn Tất Thành, Đồng Nai', '0978654312'),
  (N'Nhà cung cấp Vật liệu Xây dựng Thái Sơn', N'P. Trần Hưng Đạo, Thái Bình', '0863147295'),
  (N'Công ty TNHH Thương mại Vật liệu Xây dựng Tâm Đức', N'Ngõ 29, Đại La, Hà Nội', '0923145687'),
  (N'Nhà phân phối Vật liệu Xây dựng Trần Gia', N'Phố Nguyễn Trãi, Quảng Nam', '0965874123'),
  (N'Công ty Cổ phần Xây dựng và Vật liệu Hưng Đạt', N'Trường Chinh, Hải Phòng', '0932456781'),
  (N'Nhà cung cấp Vật liệu Xây dựng Bình Dương', N'Ngõ 89, Mạc Thị Bưởi, Bình Dương', '0812345679'),
  (N'Công ty TNHH Thương mại Vật liệu Xây dựng Mỹ Phú', N'Đường Đại Lộc, Lâm Đồng', '0921345678'),
  (N'Nhà phân phối Vật liệu Xây dựng Quốc Việt', N'Phố Nguyễn Trãi, Hà Nam', '0932145678'),
  (N'Công ty Cổ phần Xây dựng và Vật liệu Xanh Việt', N'Trường Chinh, Hải Dương', '0912456789'),
  (N'Nhà cung cấp Vật liệu Xây dựng Hưng Thịnh', N'Đường Lê Lợi, Lào Cai', '0954871236');
GO


INSERT INTO LOAIHANG (TENLOAI, DVT)
VALUES 
	(N'Sắt thép', N'Tấm'),
	(N'Cát xây dựng', N'Tấn'),
	(N'Đá xây dựng', N'Khối'),
	(N'Gạch', N'Viên'),
	(N'Xi măng', N'Bao'),
	(N'Sơn', N'Lít'),
	(N'Bê tông', N'Khối'),
	(N'Gỗ xây dựng', N'Cây'),
	(N'Thép ống', N'Cây'),
	(N'Tôn', N'Tấm'),
	(N'Cửa gỗ', N'Cái'),
	(N'Cửa nhôm', N'Cái'),
	(N'Gạch lát nền', N'Viên'),
	(N'Vật liệu chống thấm', N'Cuộn'),
	(N'Sàn gỗ', N'Khối');
GO	


INSERT INTO SANPHAM (MALH, MANCC, TENSP, GIA)
VALUES
    -- Category: Sắt thép
    (1, 5, N'Tấm thép 1mm', 200000),
    (1, 12, N'Ống thép đen 2 inch', 50000),
    (1, 15, N'Thép hình chữ U 80x40x5', 300000),
    (1, 8, N'Thép chữ T 100x100x10', 400000),
    (1, 10, N'Thép tấm 4mm', 250000),
    
    -- Category: Cát xây dựng
    (2, 3, N'Cát xây dựng loại 1', 150000),
    (2, 7, N'Cát xây dựng loại 2', 120000),
    (2, 9, N'Cát xây dựng loại 3', 100000),
    (2, 13, N'Cát sông', 110000),
    (2, 6, N'Cát sa mạc', 130000),
    
    -- Category: Đá xây dựng
    (3, 2, N'Đá xanh 20x20x5', 80000),
    (3, 4, N'Đá vôi', 70000),
    (3, 11, N'Đá granite 60x60', 150000),
    (3, 16, N'Đá cẩm thạch', 90000),
    (3, 19, N'Đá cuội', 100000),
    
    -- Category: Gạch
    (4, 1, N'Gạch bóng kiếng 20x20', 4000),
    (4, 17, N'Gạch men trắng 30x30', 6000),
    (4, 18, N'Gạch men đỏ 30x30', 5500),
    (4, 20, N'Gạch không nung 10x10', 3000),
    (4, 14, N'Gạch mosaic 5x5', 8000),
    
    -- Category: Xi măng
    (5, 5, N'Xi măng Holcim', 95000),
    (5, 12, N'Xi măng Vinakem', 90000),
    (5, 15, N'Xi măng Nghi Sơn', 100000),
    (5, 8, N'Xi măng Hà Tiên', 98000),
    (5, 10, N'Xi măng Hoàng Thạch', 97000),
    
    -- Category: Sơn
    (6, 3, N'Sơn nước Dulux màu trắng', 350000),
    (6, 7, N'Sơn dầu TOA màu xanh', 250000),
    (6, 9, N'Sơn gỗ OTTO màu nâu', 300000),
    (6, 13, N'Sơn chống thấm Pidilite', 400000),
    (6, 6, N'Sơn phủ gốm CMC', 380000),
    
    -- Category: Bê tông
    (7, 2, N'Bê tông ly tâm B20', 1200000),
    (7, 4, N'Bê tông xi măng B30', 1500000),
    (7, 11, N'Bê tông tươi B25', 1300000),
    (7, 16, N'Bê tông tự nhiên B35', 1800000),
    (7, 19, N'Bê tông trát tường B15', 1100000),
    
    -- Category: Gỗ xây dựng
    (8, 1, N'Gỗ thông 2x4', 500000),
    (8, 17, N'Gỗ căm xe 5x5', 600000),
    (8, 18, N'Gỗ gụ 10x10', 800000),
    (8, 20, N'Gỗ sồi 2x6', 700000),
    (8, 14, N'Gỗ thông ép 12mm', 450000),
    
    -- Category: Thép ống
    (9, 5, N'Thép ống đen 1 inch', 70000),
    (9, 12, N'Thép ống mạ kẽm 2 inch', 95000),
    (9, 15, N'Thép ống đúc 3 inch', 120000),
    (9, 8, N'Thép ống mạ inox 4 inch', 150000),
    (9, 10, N'Thép ống vuông 50x50x3', 80000),
    
    -- Category: Tôn
    (10, 3, N'Tôn màu kẽm 0.4mm', 60000),
    (10, 7, N'Tôn mạ kẽm 0.5mm', 70000),
    (10, 9, N'Tôn sóng chữ V 0.6mm', 80000),
    (10, 13, N'Tôn mạ màu 0.8mm', 100000),
    (10, 6, N'Tôn lạnh 1mm', 120000),
    
    -- Category: Cửa gỗ
    (11, 2, N'Cửa gỗ tự nhiên dán veneer', 1500000),
    (11, 4, N'Cửa gỗ công nghiệp HDF', 1000000),
    (11, 11, N'Cửa gỗ tự nhiên sơn PU', 1800000),
    (11, 16, N'Cửa gỗ HDF phủ melamine', 1200000),
    (11, 19, N'Cửa gỗ tự nhiên chống cháy', 2000000),
    
    -- Category: Cửa nhôm
    (12, 1, N'Cửa nhôm xingfa màu trắng', 2800000),
    (12, 17, N'Cửa nhôm triệu phú màu đen', 3200000),
    (12, 18, N'Cửa nhôm Hoà Phát màu ghi', 3000000),
    (12, 20, N'Cửa nhôm WinDoor màu xanh', 2900000),
    (12, 14, N'Cửa nhôm Việt Pháp màu nâu', 3100000),
    
    -- Category: Gạch lát nền
    (13, 5, N'Gạch lát nền ceramic 30x30', 80000),
    (13, 12, N'Gạch lát nền granite 60x60', 160000),
    (13, 15, N'Gạch lát nền gốm ốp bức 20x20', 120000),
    (13, 8, N'Gạch lát nền đồng tâm 40x40', 140000),
    (13, 10, N'Gạch lát nền đồng kỵ 25x25', 100000),
    
    -- Category: Vật liệu chống thấm
    (14, 3, N'Vật liệu chống thấm Sika', 350000),
    (14, 7, N'Vật liệu chống thấm Fosroc', 400000),
    (14, 9, N'Vật liệu chống thấm Bostik', 380000),
    (14, 13, N'Vật liệu chống thấm Dr. Fixit', 450000),
    (14, 6, N'Vật liệu chống thấm Tam Ngoc', 320000),
    
    -- Category: Sàn gỗ
    (15, 2, N'Sàn gỗ công nghiệp AC3', 300000),
    (15, 4, N'Sàn gỗ tự nhiên sồi', 500000),
    (15, 11, N'Sàn gỗ composite', 350000),
    (15, 16, N'Sàn gỗ lát nền vinyl', 400000),
    (15, 19, N'Sàn gỗ tự nhiên teak', 550000);
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
    (1, 1, 105),
    (1, 23, 65),
    (2, 8, 87),
    (1, 12, 134),
    (2, 45, 71),
    (1, 5, 89),
    (1, 32, 97),
    (1, 19, 77),
    (2, 14, 183),
    (1, 4, 91),
    (2, 61, 236),
    (1, 28, 112),
    (2, 17, 205),
    (1, 6, 126),
    (2, 53, 69),
    (1, 42, 69),
    (1, 2, 190),
    (2, 9, 81),
    (1, 67, 61),
    (1, 33, 121),
    (2, 48, 82),
    (1, 11, 159),
    (2, 39, 83),
    (1, 24, 68),
    (2, 75, 73),
    (1, 3, 134),
    (1, 15, 108),
    (2, 22, 62),
    (1, 10, 166),
    (2, 20, 107),

    (3, 5, 156),
    (3, 14, 87),
    (3, 9, 123),
    (3, 27, 192),
    (3, 35, 81),
    (3, 67, 163),
    (3, 10, 108),
    (3, 46, 211),
    (3, 72, 63),
    (3, 39, 194),
    (4, 17, 93),
    (4, 23, 78),
    (4, 8, 121),
    (4, 61, 65),
    (4, 3, 172),
    (4, 42, 99),
    (4, 28, 230),
    (4, 53, 132),
    (4, 2, 67),
    (4, 56, 158),
    (3, 19, 75),
    (3, 68, 189),
    (3, 7, 128),
    (3, 45, 203),
    (3, 55, 73),
    (3, 1, 206),
    (3, 33, 120),
    (3, 18, 85),
    (4, 29, 124),
    (4, 48, 93),

    (5, 10, 150),
    (5, 30, 98),
    (5, 20, 212),
    (6, 5, 170),
    (5, 50, 89),
    (6, 15, 124),
    (5, 25, 193),
    (6, 45, 76),
    (5, 35, 218),
    (6, 55, 62),
    (5, 60, 182),
    (6, 1, 101),
    (5, 70, 145),
    (5, 40, 200),
    (6, 65, 112),
    (5, 75, 83),
    (6, 8, 165),
    (5, 13, 236),
    (6, 3, 57),
    (5, 22, 131),
    (6, 68, 189),
    (5, 7, 77),
    (6, 33, 202),
    (5, 17, 156),
    (6, 2, 68),
    (5, 72, 178),
    (6, 38, 123),
    (5, 11, 95),
    (6, 23, 215),
    (5, 53, 104),

    (7, 5, 102),
    (8, 12, 78),
    (7, 45, 131),
    (8, 31, 95),
    (7, 20, 67),
    (7, 52, 183),
    (8, 8, 204),
    (7, 64, 89),
    (8, 19, 112),
    (7, 36, 179),
    (7, 6, 121),
    (8, 58, 68),
    (7, 38, 96),
    (8, 43, 125),
    (7, 1, 82),
    (8, 67, 146),
    (7, 13, 108),
    (7, 24, 57),
    (8, 71, 236),
    (7, 55, 175),
    (7, 29, 132),
    (8, 39, 73),
    (7, 42, 198),
    (8, 26, 139),
    (7, 61, 91),
    (8, 15, 117),
    (7, 73, 76),
    (7, 9, 204),
    (8, 25, 124),
    (7, 68, 161),

    (9, 1, 152),
    (9, 15, 102),
    (10, 6, 193),
    (9, 42, 68),
    (9, 23, 123),
    (10, 5, 98),
    (9, 19, 167),
    (10, 65, 185),
    (9, 9, 77),
    (10, 34, 221),
    (10, 11, 205),
    (10, 73, 121),
    (9, 67, 84),
    (10, 3, 109),
    (9, 20, 190),
    (10, 51, 146),
    (9, 16, 63),
    (10, 41, 74),
    (10, 30, 180),
    (9, 4, 212),
    (10, 50, 136),
    (9, 7, 98),
    (9, 13, 119),
    (10, 70, 198),
    (10, 21, 174),
    (9, 48, 155),
    (9, 25, 84),
    (10, 63, 107),
    (10, 58, 89),
    (9, 17, 157),
    (10, 72, 227);
GO


INSERT INTO HOADON (MAKHACH, MAKHO, NGAYLAPHOADON, LOAIHOADON, TRANGTHAI)
VALUES
  (1, 1, '2023-01-09', N'Nhập', 'Returned'),
  (20, 10, '2023-01-10', N'Xuất', 'Success'),
  (2, 2, '2023-01-11', N'Nhập', 'Pending'),
  (12, 3, '2023-01-12', N'Xuất', 'Delivering'),
  (3, 3, '2023-02-13', N'Nhập', 'Cancelled'),
  (14, 5, '2023-02-14', N'Xuất', 'Returned'),
  (5, 5, '2023-02-15', N'Nhập', 'Success'),
  (16, 7, '2023-02-16', N'Xuất', 'Pending'),
  (7, 7, '2023-03-17', N'Nhập', 'Delivering'),
  (18, 9, '2023-03-18', N'Xuất', 'Cancelled'),
  (9, 9, '2023-03-19', N'Nhập', 'Returned'),
  (20, 1, '2023-03-20', N'Xuất', 'Success'),
  (1, 1, '2023-04-21', N'Nhập', 'Pending'),
  (12, 4, '2023-04-22', N'Xuất', 'Delivering'),
  (3, 3, '2023-04-23', N'Nhập', 'Cancelled'),
  (14, 6, '2023-04-24', N'Xuất', 'Returned'),
  (5, 5, '2023-05-25', N'Nhập', 'Success'),
  (16, 8, '2023-05-26', N'Xuất', 'Pending'),
  (7, 7, '2023-05-27', N'Nhập', 'Delivering'),
  (18, 10, '2023-05-28', N'Xuất', 'Cancelled'),
  (9, 9, '2023-05-29', N'Nhập', 'Returned'),
  (20, 2, '2023-05-30', N'Xuất', 'Success'),
  (1, 1, '2023-05-01', N'Nhập', 'Pending'),
  (12, 2, '2023-05-02', N'Xuất', 'Delivering'),
  (3, 3, '2023-06-03', N'Nhập', 'Cancelled'),
  (14, 4, '2023-06-04', N'Xuất', 'Returned'),
  (5, 5, '2023-06-05', N'Nhập', 'Success'),
  (16, 6, '2023-06-06', N'Xuất', 'Pending'),
  (7, 7, '2023-06-07', N'Nhập', 'Delivering'),
  (18, 8, '2023-06-08', N'Xuất', 'Cancelled');
GO


INSERT INTO HOADONCHITIET (MASP, MAHD, SOLUONG) VALUES
	(9, 5, 45),
	(47, 26, 54),
	(53, 21, 42),
	(31, 4, 57),
	(15, 14, 35),
	(22, 12, 61),
	(66, 9, 41),
	(40, 27, 49),
	(67, 7, 52),
	(10, 28, 56),
	(39, 10, 47),
	(26, 20, 46),
	(37, 15, 38),
	(49, 1, 58),
	(71, 25, 35),
	(60, 11, 60),
	(63, 3, 40),
	(56, 30, 44),
	(34, 8, 55),
	(73, 19, 50),
	(14, 18, 59),
	(45, 2, 39),
	(41, 16, 53),
	(72, 29, 48),
	(8, 13, 37),
	(12, 6, 51),
	(5, 24, 43),
	(25, 17, 36),
	(21, 22, 60),
	(58, 23, 41),
	(17, 6, 37),
	(72, 11, 53),
	(50, 10, 43),
	(29, 1, 50),
	(3, 19, 39),
	(59, 4, 58),
	(38, 30, 35),
	(33, 9, 60),
	(69, 20, 42),
	(6, 27, 61),
	(18, 13, 41),
	(68, 2, 44),
	(51, 22, 36),
	(43, 23, 59),
	(27, 18, 47),
	(57, 21, 46),
	(64, 15, 55),
	(19, 12, 49),
	(48, 16, 45),
	(35, 5, 52),
	(75, 25, 57),
	(13, 3, 38),
	(23, 17, 48),
	(54, 29, 54),
	(62, 8, 40),
	(30, 24, 56),
	(70, 14, 51),
	(2, 26, 37),
	(46, 7, 43),
	(7, 28, 35),
	(74, 18, 60),
	(42, 13, 39),
	(36, 21, 51),
	(16, 10, 38),
	(55, 28, 45),
	(9, 17, 35),
	(14, 19, 50),
	(19, 2, 57),
	(31, 1, 37),
	(24, 8, 55),
	(63, 3, 56),
	(28, 20, 43),
	(75, 6, 44),
	(56, 4, 36),
	(44, 27, 60),
	(34, 14, 42),
	(15, 25, 53),
	(8, 9, 41),
	(47, 30, 59),
	(1, 11, 49),
	(61, 5, 40),
	(23, 26, 52),
	(12, 12, 46),
	(66, 16, 48),
	(57, 7, 54),
	(69, 23, 37),
	(49, 15, 61),
	(60, 22, 38),
	(43, 24, 57),
	(64, 29, 35);
GO


-- TRIGGER SANPHAM
CREATE OR ALTER TRIGGER trg_SANPHAM_insert
ON SANPHAM
INSTEAD OF INSERT
AS
BEGIN
    INSERT INTO SANPHAM (MALH, MANCC, TENSP, GIA)
    SELECT
		inserted.MALH,
        CASE WHEN inserted.MANCC = 0 THEN NULL ELSE inserted.MANCC END,
        inserted.TENSP,
        inserted.GIA
    FROM inserted;
END
GO


-- TRIGGER HOADON
CREATE OR ALTER TRIGGER trg_HOADON_Update
ON HOADON
AFTER UPDATE
AS
BEGIN
    IF UPDATE(TRANGTHAI)
    BEGIN
        -- Update KHOHANGCHITIET for the affected MAKHO
        UPDATE khct
        SET khct.SOLUONG = khct.SOLUONG + hdct.SOLUONG
        FROM KHOHANGCHITIET khct
        JOIN HOADONCHITIET hdct ON khct.MASP = hdct.MASP
        JOIN inserted i ON hdct.MAHD = i.MAHD
        WHERE i.TRANGTHAI = 'Success' AND i.LOAIHOADON = N'Nhập' AND khct.MAKHO = i.MAKHO
        
        -- Insert new rows into KHOHANGCHITIET for the affected MAKHO
        INSERT INTO KHOHANGCHITIET (MAKHO, MASP, SOLUONG)
        SELECT i.MAKHO, hdct.MASP, hdct.SOLUONG
        FROM HOADONCHITIET hdct
        JOIN inserted i ON hdct.MAHD = i.MAHD
        WHERE i.TRANGTHAI LIKE 'Success' AND i.LOAIHOADON LIKE N'Nhập' AND hdct.MASP NOT IN (
            SELECT MASP FROM KHOHANGCHITIET WHERE MAKHO = i.MAKHO
        )
    END
END
GO

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


-- TRIGGER HOADONCHITIET
CREATE OR ALTER TRIGGER trg_HOADONCHITIET_insert
ON HOADONCHITIET
AFTER INSERT
AS
BEGIN
    UPDATE khct
    SET khct.SOLUONG = khct.SOLUONG - i.SOLUONG
    FROM KHOHANGCHITIET khct
    JOIN inserted i ON khct.MASP = i.MASP
    JOIN HOADON hd ON i.MAHD = hd.MAHD
    WHERE hd.LOAIHOADON = N'Xuất' AND khct.MAKHO = hd.MAKHO;
END
GO

CREATE OR ALTER TRIGGER trg_HOADONCHITIET_update
ON HOADONCHITIET
INSTEAD OF UPDATE
AS
BEGIN
    -- Update KHOHANGCHITIET for 'Xuất' type of HOADON with 'Pending' status
    UPDATE khct
    SET khct.SOLUONG = khct.SOLUONG + (i.SOLUONG - d.SOLUONG)
    FROM KHOHANGCHITIET khct
    JOIN inserted i ON khct.MASP = i.MASP
    JOIN deleted d ON khct.MASP = d.MASP
    JOIN HOADON hd ON i.MAHD = hd.MAHD
    WHERE hd.LOAIHOADON = N'Xuất' AND hd.TRANGTHAI = 'Pending' AND khct.MAKHO = hd.MAKHO;

	-- Update KHOHANGCHITIET for 'Xuất' type of HOADON with 'Cancelled' status
	UPDATE khct
    SET khct.SOLUONG = khct.SOLUONG + d.SOLUONG
    FROM KHOHANGCHITIET khct
    JOIN inserted i ON khct.MASP = i.MASP
    JOIN deleted d ON khct.MASP = d.MASP
    JOIN HOADON hd ON i.MAHD = hd.MAHD
    WHERE hd.LOAIHOADON = N'Xuất' AND hd.TRANGTHAI = 'Cancelled' AND khct.MAKHO = hd.MAKHO;


    -- Update the HOADONCHITIET table with the new SOLUONG value
    UPDATE hdct
    SET hdct.SOLUONG = i.SOLUONG
    FROM HOADONCHITIET hdct
    JOIN inserted i ON hdct.MAHD = i.MAHD AND hdct.MASP = i.MASP;
END
GO

CREATE OR ALTER TRIGGER trg_HOADONCHITIET_delete
ON HOADONCHITIET
INSTEAD OF DELETE
AS
BEGIN
    -- Update KHOHANGCHITIET for 'Xuất' type of HOADON with 'Pending' status
    UPDATE khct
    SET khct.SOLUONG = khct.SOLUONG + d.SOLUONG
    FROM KHOHANGCHITIET khct
    JOIN deleted d ON khct.MASP = d.MASP
    JOIN HOADON h ON d.MAHD = h.MAHD
    WHERE h.LOAIHOADON = N'Xuất' AND h.TRANGTHAI = 'Pending' AND khct.MAKHO = h.MAKHO;

    -- Delete the row from HOADONCHITIET
    DELETE FROM HOADONCHITIET
    WHERE MAHD IN (SELECT MAHD FROM deleted) AND MASP IN (SELECT MASP FROM deleted);
END
GO


/*
EXEC sp_MSforeachtable @command1 = "DROP TABLE ?"
*\