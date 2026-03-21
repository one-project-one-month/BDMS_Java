-- =====================================================
-- BDMS (Blood Donation Management System) - Sample Data
-- =====================================================
-- Enum values are stored as Integer (BaseEnum.value):
--   Gender:              1=Male, 2=Female, 3=Other
--   BloodGroup:          1=A+, 2=A-, 3=B+, 4=B-, 5=AB+, 6=AB-, 7=O+, 8=O-
--   AppointmentStatus:   1=Scheduled, 2=Confirmed, 3=Cancelled, 4=Completed
--   DonationStatus:      1=Pending, 2=Cancelled, 3=Approved, 4=Screening, 5=Rejected, 6=Completed
--   BloodRequestStatus:  1=Pending, 2=Cancelled, 3=Approved, 4=Rejected, 5=Fulfilled
--   Urgency:             1=Low, 2=Medium, 3=High, 4=Critical
--   BloodInventoryStatus:1=Available, 2=Used, 3=Expired
--   ScreeningStatus:     1=Pending, 2=Failed, 3=Passed
--   TestResult:          1=Positive, 2=Negative, 3=Inconclusive
-- =====================================================

-- =====================================================
-- 1. PERMISSIONS
-- =====================================================
INSERT INTO permissions (name, is_active, created_at, updated_at) VALUES
('CREATE_USER',     TRUE, NOW(), NOW()),
('READ_USER',       TRUE, NOW(), NOW()),
('UPDATE_USER',     TRUE, NOW(), NOW()),
('DELETE_USER',     TRUE, NOW(), NOW()),
('CREATE_DONOR',    TRUE, NOW(), NOW()),
('READ_DONOR',      TRUE, NOW(), NOW()),
('UPDATE_DONOR',    TRUE, NOW(), NOW()),
('DELETE_DONOR',    TRUE, NOW(), NOW()),
('CREATE_DONATION', TRUE, NOW(), NOW()),
('READ_DONATION',   TRUE, NOW(), NOW()),
('UPDATE_DONATION', TRUE, NOW(), NOW()),
('DELETE_DONATION', TRUE, NOW(), NOW()),
('MANAGE_BLOOD_REQUEST',  TRUE, NOW(), NOW()),
('MANAGE_BLOOD_INVENTORY', TRUE, NOW(), NOW()),
('MANAGE_HOSPITAL', TRUE, NOW(), NOW()),
('MANAGE_ANNOUNCEMENT', TRUE, NOW(), NOW());

-- =====================================================
-- 2. ROLES
-- =====================================================
INSERT INTO roles (name, is_active, created_at, updated_at) VALUES
('ADMIN',          TRUE, NOW(), NOW()),
('HOSPITAL_STAFF', TRUE, NOW(), NOW()),
('DONOR',          TRUE, NOW(), NOW());

-- =====================================================
-- 3. ROLE_PERMISSIONS
-- =====================================================
-- ADMIN (role_id=1) gets all permissions (1-16)
INSERT INTO role_permissions (role_id, permission_id, is_active, created_at, updated_at) VALUES
(1, 1,  TRUE, NOW(), NOW()),
(1, 2,  TRUE, NOW(), NOW()),
(1, 3,  TRUE, NOW(), NOW()),
(1, 4,  TRUE, NOW(), NOW()),
(1, 5,  TRUE, NOW(), NOW()),
(1, 6,  TRUE, NOW(), NOW()),
(1, 7,  TRUE, NOW(), NOW()),
(1, 8,  TRUE, NOW(), NOW()),
(1, 9,  TRUE, NOW(), NOW()),
(1, 10, TRUE, NOW(), NOW()),
(1, 11, TRUE, NOW(), NOW()),
(1, 12, TRUE, NOW(), NOW()),
(1, 13, TRUE, NOW(), NOW()),
(1, 14, TRUE, NOW(), NOW()),
(1, 15, TRUE, NOW(), NOW()),
(1, 16, TRUE, NOW(), NOW());

-- HOSPITAL_STAFF (role_id=2)
INSERT INTO role_permissions (role_id, permission_id, is_active, created_at, updated_at) VALUES
(2, 2,  TRUE, NOW(), NOW()),
(2, 6,  TRUE, NOW(), NOW()),
(2, 9,  TRUE, NOW(), NOW()),
(2, 10, TRUE, NOW(), NOW()),
(2, 11, TRUE, NOW(), NOW()),
(2, 13, TRUE, NOW(), NOW()),
(2, 14, TRUE, NOW(), NOW());

-- DONOR (role_id=3)
INSERT INTO role_permissions (role_id, permission_id, is_active, created_at, updated_at) VALUES
(3, 6,  TRUE, NOW(), NOW()),
(3, 10, TRUE, NOW(), NOW());

-- =====================================================
-- 4. HOSPITALS
-- =====================================================
INSERT INTO hospitals (name, address, phone, email, is_verified, is_active, created_at, updated_at) VALUES
('Yangon General Hospital',    '123 Bogyoke Rd, Yangon',     '09-111-1111', 'info@ygh.com',       TRUE,  TRUE, NOW(), NOW()),
('Mandalay General Hospital',  '456 78th St, Mandalay',      '09-222-2222', 'info@mdygh.com',     TRUE,  TRUE, NOW(), NOW()),
('Naypyidaw Hospital',         '789 Capital Ave, Naypyidaw', '09-333-3333', 'info@npthosp.com',   TRUE,  TRUE, NOW(), NOW()),
('Taunggyi Hospital',          '101 Shan Rd, Taunggyi',      '09-444-4444', 'info@tgihosp.com',   FALSE, TRUE, NOW(), NOW()),
('Monywa General Hospital',    '202 Sagaing Rd, Monywa',     '09-555-5555', 'info@monywahosp.com', TRUE, TRUE, NOW(), NOW());

-- =====================================================
-- 5. USERS
-- =====================================================
-- Admin user (role_id=1)
INSERT INTO users (role_id, hospital_id, user_name, email, password, is_active, created_at, updated_at) VALUES
(1, NULL, 'Admin User',       'admin@bdms.com',          '$2a$10$xJwL5v0Bz1qZ1q1q1q1q1u', TRUE, NOW(), NOW()),
(2, 1,    'Dr. Aung Kyaw',    'aungkyaw@ygh.com',        '$2a$10$xJwL5v0Bz1qZ1q1q1q1q1u', TRUE, NOW(), NOW()),
(2, 2,    'Dr. Su Su',        'susu@mdygh.com',          '$2a$10$xJwL5v0Bz1qZ1q1q1q1q1u', TRUE, NOW(), NOW()),
(2, 3,    'Nurse Hla Hla',    'hlahla@npthosp.com',      '$2a$10$xJwL5v0Bz1qZ1q1q1q1q1u', TRUE, NOW(), NOW()),
(3, NULL, 'Ko Min Thu',       'minthu@gmail.com',         '$2a$10$xJwL5v0Bz1qZ1q1q1q1q1u', TRUE, NOW(), NOW()),
(3, NULL, 'Ma Aye Chan',      'ayechan@gmail.com',        '$2a$10$xJwL5v0Bz1qZ1q1q1q1q1u', TRUE, NOW(), NOW()),
(3, NULL, 'Ko Zaw Win',       'zawwin@gmail.com',         '$2a$10$xJwL5v0Bz1qZ1q1q1q1q1u', TRUE, NOW(), NOW()),
(3, NULL, 'Ma Thin Thin',     'thinthin@gmail.com',       '$2a$10$xJwL5v0Bz1qZ1q1q1q1q1u', TRUE, NOW(), NOW()),
(3, NULL, 'Ko Htet Aung',     'htetaung@gmail.com',       '$2a$10$xJwL5v0Bz1qZ1q1q1q1q1u', TRUE, NOW(), NOW()),
(3, NULL, 'Ma Phyu Phyu',     'phyuphyu@gmail.com',       '$2a$10$xJwL5v0Bz1qZ1q1q1q1q1u', TRUE, NOW(), NOW());

-- =====================================================
-- 6. DONORS (linked to users 5-10, who have role DONOR)
-- =====================================================
-- Gender: 1=Male, 2=Female | BloodGroup: 1=A+, 2=A-, 3=B+, 4=B-, 5=AB+, 6=AB-, 7=O+, 8=O-
INSERT INTO donors (user_id, nrc_no, date_of_birth, gender, blood_group, weight, last_donation_date, remarks, emergency_contact, emergency_phone, address, is_active, created_at, updated_at) VALUES
(5,  '12/YAKANA(N)123456', '1995-03-15', 1, 1, 70.50, '2025-12-01', 'Healthy donor',         'U Maung Maung',  '09-600-6001', '45 Insein Rd, Yangon',       TRUE, NOW(), NOW()),
(6,  '12/THMKA(N)234567',  '1998-07-22', 2, 3, 55.00, '2025-11-15', 'Regular donor',         'Daw Khin Khin',  '09-600-6002', '78 Pyay Rd, Yangon',         TRUE, NOW(), NOW()),
(7,  '09/MDYA(N)345678',   '1990-01-10', 1, 7, 80.00, '2026-01-10', 'First-time donor',      'Ko Tun Tun',     '09-600-6003', '23 66th St, Mandalay',       TRUE, NOW(), NOW()),
(8,  '12/THGKA(N)456789',  '2000-11-05', 2, 5, 52.00, NULL,         'New donor, no history',  'Daw Mya Mya',    '09-600-6004', '56 Baho Rd, Yangon',         TRUE, NOW(), NOW()),
(9,  '14/BKLA(N)567890',   '1993-05-30', 1, 8, 75.00, '2026-02-20', 'Active donor',          'U Win Naing',    '09-600-6005', '12 Strand Rd, Yangon',       TRUE, NOW(), NOW()),
(10, '12/OUKMTA(N)678901', '1997-09-18', 2, 2, 58.00, '2025-10-05', 'Occasional donor',      'Daw Htay Htay',  '09-600-6006', '89 University Ave, Yangon',  TRUE, NOW(), NOW());

-- =====================================================
-- 7. ANNOUNCEMENTS
-- =====================================================
INSERT INTO announcements (title, content, expired_at, is_active, created_at, updated_at) VALUES
('Blood Donation Drive - Yangon',    'Join us for a blood donation drive at Yangon General Hospital on April 5th, 2026. All blood types are needed!',          '2026-04-05', TRUE, NOW(), NOW()),
('Urgent: O- Blood Needed',          'We are critically low on O- blood. If you are O- negative, please consider donating at your nearest hospital.',           '2026-04-15', TRUE, NOW(), NOW()),
('World Blood Donor Day 2026',       'Celebrate World Blood Donor Day on June 14th! Special events and free health checkups for all donors.',                   '2026-06-14', TRUE, NOW(), NOW()),
('New Hospital Partnership',         'We are proud to announce our new partnership with Taunggyi Hospital. More donation centers coming soon!',                 '2026-05-01', TRUE, NOW(), NOW()),
('System Maintenance Notice',        'The BDMS system will undergo maintenance on March 25th from 2:00 AM to 4:00 AM. Please plan accordingly.',               '2026-03-25', TRUE, NOW(), NOW());

-- =====================================================
-- 8. BLOOD REQUESTS
-- =====================================================
-- BloodRequestStatus: 1=Pending, 2=Cancelled, 3=Approved | Urgency: 1=Low, 2=Medium, 3=High, 4=Critical
INSERT INTO blood_requests (user_id, hospital_id, blood_request_code, patient_name, blood_group, units_required, contact_phone, urgency, required_date, status, reason, approved_by, approved_at, is_active, created_at, updated_at) VALUES
(2, 1, 'BR-2026-001', 'U Kyaw Kyaw',    1, 3, '09-700-7001', 3, '2026-03-22', 3, 'Surgery scheduled',           1, NOW(), TRUE, NOW(), NOW()),
(3, 2, 'BR-2026-002', 'Daw Yin Yin',    7, 2, '09-700-7002', 4, '2026-03-21', 1, 'Emergency accident victim',   NULL, NULL, TRUE, NOW(), NOW()),
(2, 1, 'BR-2026-003', 'Ma Nilar',        3, 1, '09-700-7003', 2, '2026-03-25', 1, 'Postpartum hemorrhage',       NULL, NULL, TRUE, NOW(), NOW()),
(4, 3, 'BR-2026-004', 'Ko Zaw Zaw',      8, 4, '09-700-7004', 4, '2026-03-20', 3, 'Major surgery - liver',       1, NOW(), TRUE, NOW(), NOW()),
(3, 2, 'BR-2026-005', 'Daw Tin Tin',      5, 2, '09-700-7005', 1, '2026-04-01', 1, 'Scheduled transfusion',       NULL, NULL, TRUE, NOW(), NOW());

-- =====================================================
-- 9. DONATIONS
-- =====================================================
-- DonationStatus: 1=Pending, 3=Approved, 6=Completed
INSERT INTO donations (donor_id, hospital_id, blood_request_id, donation_code, blood_group, units_donated, donation_date, status, approved_by, approved_at, remarks, is_active, created_at, updated_at) VALUES
(1, 1, 1,    'DN-2026-001', 1, 1, '2026-03-18', 6, 2, NOW(), 'Successful donation',          TRUE, NOW(), NOW()),
(3, 2, NULL, 'DN-2026-002', 7, 1, '2026-03-17', 6, 3, NOW(), 'Voluntary donation',           TRUE, NOW(), NOW()),
(5, 1, 1,    'DN-2026-003', 8, 2, '2026-03-19', 3, 2, NOW(), 'Approved, awaiting screening', TRUE, NOW(), NOW()),
(2, 1, NULL, 'DN-2026-004', 3, 1, '2026-03-20', 1, NULL, NULL, 'Pending approval',           TRUE, NOW(), NOW()),
(4, 3, 4,    'DN-2026-005', 5, 1, '2026-03-19', 6, 4, NOW(), 'Completed for blood request',  TRUE, NOW(), NOW()),
(6, 2, NULL, 'DN-2026-006', 2, 1, '2026-03-15', 6, 3, NOW(), 'Regular donation',             TRUE, NOW(), NOW());

-- =====================================================
-- 10. APPOINTMENTS
-- =====================================================
-- AppointmentStatus: 1=Scheduled, 2=Confirmed, 4=Completed
INSERT INTO appointments (user_id, hospital_id, donation_id, blood_request_id, appointment_date, appointment_time, status, remarks, is_active, created_at, updated_at) VALUES
(5,  1, 1,    1,    '2026-03-18', '09:00:00', 4, 'Completed donation appointment',   TRUE, NOW(), NOW()),
(7,  2, 2,    NULL, '2026-03-17', '10:30:00', 4, 'Walk-in donor, completed',          TRUE, NOW(), NOW()),
(9,  1, 3,    1,    '2026-03-19', '14:00:00', 2, 'Confirmed for tomorrow',            TRUE, NOW(), NOW()),
(6,  1, NULL, NULL, '2026-03-25', '11:00:00', 1, 'Scheduled for next week',           TRUE, NOW(), NOW()),
(8,  3, 5,    4,    '2026-03-19', '08:30:00', 4, 'Emergency donation completed',      TRUE, NOW(), NOW()),
(10, 2, 6,    NULL, '2026-03-15', '15:00:00', 4, 'Regular donation completed',        TRUE, NOW(), NOW());

-- =====================================================
-- 11. MEDICAL RECORDS
-- =====================================================
-- TestResult: 1=Positive, 2=Negative, 3=Inconclusive | ScreeningStatus: 1=Pending, 2=Failed, 3=Passed
INSERT INTO medical_records (donation_id, hospital_id, hemoglobin_level, hiv_result, hepatitis_b_result, hepatitis_c_result, malaria_result, syphilis_result, blood_group, screening_status, screening_notes, screened_by, screening_at, is_active, created_at, updated_at) VALUES
(1, 1, 14.50, 2, 2, 2, 2, 2, 1, 3, 'All tests negative. Donor cleared.',              2, NOW(), TRUE, NOW(), NOW()),
(2, 2, 13.80, 2, 2, 2, 2, 2, 7, 3, 'Healthy donor, all tests passed.',                3, NOW(), TRUE, NOW(), NOW()),
(5, 3, 12.50, 2, 2, 2, 2, 2, 5, 3, 'All tests clear. Good hemoglobin.',               4, NOW(), TRUE, NOW(), NOW()),
(6, 2, 15.00, 2, 2, 2, 2, 2, 2, 3, 'Excellent health, all tests negative.',           3, NOW(), TRUE, NOW(), NOW());

-- =====================================================
-- 12. BLOOD INVENTORIES
-- =====================================================
-- BloodInventoryStatus: 1=Available, 2=Used, 3=Expired
INSERT INTO blood_inventories (donation_id, hospital_id, blood_group, units, collected_at, expired_at, status, blood_request_id, is_active, created_at, updated_at) VALUES
(1, 1, 1, 1, '2026-03-18', '2026-04-18', 1, NULL, TRUE, NOW(), NOW()),
(2, 2, 7, 1, '2026-03-17', '2026-04-17', 1, NULL, TRUE, NOW(), NOW()),
(5, 3, 5, 1, '2026-03-19', '2026-04-19', 1, 4,    TRUE, NOW(), NOW()),
(6, 2, 2, 1, '2026-03-15', '2026-04-15', 1, NULL, TRUE, NOW(), NOW());

-- =====================================================
-- 13. CERTIFICATES
-- =====================================================
INSERT INTO certificates (user_id, certificate_title, certificate_description, certificate_date, is_active, created_at, updated_at) VALUES
(5,  'Blood Donation Certificate',       'Certificate of appreciation for donating blood at Yangon General Hospital.',     '2026-03-18', TRUE, NOW(), NOW()),
(7,  'Blood Donation Certificate',       'Certificate of appreciation for voluntary blood donation at Mandalay Hospital.', '2026-03-17', TRUE, NOW(), NOW()),
(9,  'Regular Donor Award',              'Recognized for making 5+ donations in 2025-2026.',                                '2026-03-01', TRUE, NOW(), NOW()),
(10, 'Blood Donation Certificate',       'Certificate for blood donation at Mandalay General Hospital.',                    '2026-03-15', TRUE, NOW(), NOW());
