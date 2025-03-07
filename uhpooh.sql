-- Create and select database
DROP DATABASE IF EXISTS uhpooh;
CREATE SCHEMA IF NOT EXISTS `uhpooh` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE uhpooh;

-- Users table
CREATE TABLE users (
    id LONG PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARBINARY(255),
    user_name VARCHAR(50),
    user_address VARCHAR(255),
    profile_image VARCHAR(255),
    provider enum('UHPOOH', 'NAVER', 'GOOGLE', 'GITHUB') not null default 'UHPOOH',
    role enum('USER', 'ADMIN') not null default 'USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted TINYINT DEFAULT 0
);

-- Places table
CREATE TABLE places (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    kakao_place_id VARCHAR(100) NOT NULL UNIQUE,
    place_name VARCHAR(255) NOT NULL,
    review_count BIGINT DEFAULT 0,
    like_count BIGINT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_kakao_place_id (kakao_place_id)
);

-- Reviews table
CREATE TABLE reviews (
    reviewId INT AUTO_INCREMENT PRIMARY KEY,
    userId INT NOT NULL,
    placeId INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    regTime DATETIME DEFAULT CURRENT_TIMESTAMP,
    updTime DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (userId) REFERENCES users(userId) ON DELETE CASCADE,
    FOREIGN KEY (placeId) REFERENCES places(placeId) ON DELETE CASCADE,
    INDEX idxUserPlace (userId, placeId)
);

-- Review Images table
CREATE TABLE reviewImages (
    imageId INT AUTO_INCREMENT PRIMARY KEY,
    reviewId INT NOT NULL,
    imageUrl VARCHAR(255) NOT NULL,
    FOREIGN KEY (reviewId) REFERENCES reviews(reviewId) ON DELETE CASCADE,
    INDEX idx_review (reviewId)
);

-- Likes table
CREATE TABLE likes (
    likeId INT AUTO_INCREMENT PRIMARY KEY,
    userId INT NOT NULL,
    placeId INT NOT NULL,
    regTime DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userId) REFERENCES users(userId) ON DELETE CASCADE,
    FOREIGN KEY (placeId) REFERENCES places(placeId) ON DELETE CASCADE,
    UNIQUE KEY uniqueUserPlace (userId, placeId)
);

-- Payments table
CREATE TABLE payments (
    paymentId INT AUTO_INCREMENT PRIMARY KEY,
    userId INT NOT NULL,
    tossPaymentKey VARCHAR(200) NOT NULL,
    amount INT NOT NULL,
    status ENUM('READY', 'IN_PROGRESS', 'DONE', 'CANCELED', 'FAILED') DEFAULT 'READY',
    regTime DATETIME DEFAULT CURRENT_TIMESTAMP,
    updTime DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (userId) REFERENCES users(userId) ON DELETE CASCADE,
    INDEX idxOrderId (paymentId),
    INDEX idxPaymentKey (tossPaymentKey)
);