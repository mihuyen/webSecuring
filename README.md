# Spring Boot Security - Database Authentication Demo

Dự án này là một ví dụ mở rộng về việc bảo mật ứng dụng web sử dụng Spring Boot Security với thông tin người dùng được lưu trữ trong cơ sở dữ liệu (H2 Database).

## Tính năng

*   **Xác thực người dùng (Authentication):** Người dùng đăng nhập với thông tin được kiểm tra từ cơ sở dữ liệu.
*   **Phân quyền (Authorization):**
    *   **USER:** Có quyền truy cập các trang cơ bản sau khi đăng nhập.
    *   **ADMIN:** Có quyền truy cập trang quản trị (`/admin`).
*   **Đăng ký:** Người dùng mới có thể đăng ký tài khoản (mặc định vai trò `USER`).
*   **Cơ sở dữ liệu:** Sử dụng H2 Database (in-memory) để lưu trữ `users`.
*   **Mã hóa mật khẩu:** Sử dụng `BCryptPasswordEncoder` để bảo mật mật khẩu.

## Cài đặt và Chạy ứng dụng

### Yêu cầu
*   Java 17 trở lên
*   Maven

### Các bước chạy
1.  Clone hoặc mở dự án.
2.  Mở terminal tại thư mục gốc của dự án.
3.  Chạy lệnh sau:
    ```bash
    ./mvnw spring-boot:run
    ```
    (Hoặc `mvn spring-boot:run` nếu đã cài Maven toàn cục)

4.  Ứng dụng sẽ khởi động tại `http://localhost:8080`.

## Hướng dẫn sử dụng

### Tài khoản mặc định (Admin)
Hệ thống sẽ tự động tạo một tài khoản Admin khi khởi chạy lần đầu:
*   **Username:** `admin`
*   **Password:** `admin123`
*   **Vai trò:** `ADMIN`

### Kiểm thử phân quyền

1.  **Trang chủ (Home):**
    *   Truy cập `http://localhost:8080/`.
    *   Trang này công khai (public).
<img width="1802" height="969" alt="image" src="https://github.com/user-attachments/assets/bb6354f5-d3ae-409c-8375-be76a9615261" />


2.  **Đăng ký (Register):**
    *   Truy cập `http://localhost:8080/register`.
    *   Tạo một tài khoản mới (ví dụ: `user1` / `123456`).
    *   Sau khi đăng ký thành công sẽ chuyển hướng về trang Login.
<img width="1360" height="785" alt="image" src="https://github.com/user-attachments/assets/7a6ccbd2-9067-4d1b-b469-a6a1ed2cfda8" />


3.  **Đăng nhập (Login):**
    *   Truy cập `http://localhost:8080/login` hoặc bấm "Sign In".
    *   Đăng nhập bằng tài khoản vừa tạo hoặc tài khoản admin.
<img width="1283" height="777" alt="image" src="https://github.com/user-attachments/assets/06edec9c-340d-4f17-8e8d-5767b81cb9a1" />

4.  **Trang Admin:**
    *   Truy cập `http://localhost:8080/admin`.
    *   **Nếu đăng nhập là `admin`:** Sẽ thấy nội dung trang admin.
    *   **Nếu đăng nhập là `user1`:** Sẽ bị từ chối truy cập (Lỗi 403 Forbidden).
<img width="1161" height="696" alt="image" src="https://github.com/user-attachments/assets/f63e59c9-1194-423f-a780-b8f58491fdf6" />

5.  **H2 Console (Kiểm tra Database):**
    *   Truy cập `http://localhost:8080/h2-console`.
    *   **JDBC URL:** `jdbc:h2:mem:testdb`
    *   **User Name:** `sa`
    *   **Password:** (để trống)
    *   Bấm **Connect**.
    *   Chạy câu lệnh SQL `SELECT * FROM USERS;` để xem danh sách người dùng đã mã hóa mật khẩu.

## Cấu trúc dự án

*   `src/main/java/org/example/gssecuringweb`:
    *   `config/`: Cấu hình Security (`SecurityConfig`) và Khởi tạo dữ liệu (`DataInitializer`).
    *   `controller/`: Xử lý các request (`MainController`).
    *   `model/`: Các thực thể JPA (`User`) và Enum (`Role`).
    *   `repository/`: Interface tương tác CSDL (`UserRepository`).
    *   `service/`: Logic nghiệp vụ và Custom UserDetailsService (`UserService`).
*   `src/main/resources/templates`: Các file giao diện HTML (Thymeleaf).

---
