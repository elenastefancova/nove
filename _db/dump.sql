--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.1

-- Started on 2016-04-10 23:00:53

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2156 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 190 (class 1259 OID 16471)
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE customer (
    c_id integer NOT NULL,
    name character varying(20),
    namelast character varying(30),
    d_id bigint
);


ALTER TABLE customer OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 16469)
-- Name: customer_c_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE customer_c_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE customer_c_id_seq OWNER TO postgres;

--
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 189
-- Name: customer_c_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE customer_c_id_seq OWNED BY customer.c_id;


--
-- TOC entry 188 (class 1259 OID 16463)
-- Name: department; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE department (
    d_id integer NOT NULL,
    name character varying(30)
);


ALTER TABLE department OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 16461)
-- Name: department_s_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE department_s_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE department_s_id_seq OWNER TO postgres;

--
-- TOC entry 2158 (class 0 OID 0)
-- Dependencies: 187
-- Name: department_s_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE department_s_id_seq OWNED BY department.d_id;


--
-- TOC entry 182 (class 1259 OID 16423)
-- Name: staff; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE staff (
    s_id integer NOT NULL,
    name character varying(20),
    namelast character varying(30),
    since date
);


ALTER TABLE staff OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 16421)
-- Name: staff_s_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE staff_s_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE staff_s_id_seq OWNER TO postgres;

--
-- TOC entry 2159 (class 0 OID 0)
-- Dependencies: 181
-- Name: staff_s_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE staff_s_id_seq OWNED BY staff.s_id;


--
-- TOC entry 186 (class 1259 OID 16447)
-- Name: status; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE status (
    st_id integer NOT NULL,
    name character varying(20)
);


ALTER TABLE status OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16445)
-- Name: status_st_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE status_st_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE status_st_id_seq OWNER TO postgres;

--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 185
-- Name: status_st_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE status_st_id_seq OWNED BY status.st_id;


--
-- TOC entry 184 (class 1259 OID 16431)
-- Name: ticket; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE ticket (
    t_id integer NOT NULL,
    name character varying(20),
    descr character varying(1000),
    sinced date,
    sincet time without time zone,
    s_id bigint,
    st_id bigint,
    c_id bigint,
    tot time without time zone,
    tod date
);


ALTER TABLE ticket OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 16429)
-- Name: ticket_t_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ticket_t_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ticket_t_id_seq OWNER TO postgres;

--
-- TOC entry 2161 (class 0 OID 0)
-- Dependencies: 183
-- Name: ticket_t_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ticket_t_id_seq OWNED BY ticket.t_id;


--
-- TOC entry 2010 (class 2604 OID 16474)
-- Name: c_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY customer ALTER COLUMN c_id SET DEFAULT nextval('customer_c_id_seq'::regclass);


--
-- TOC entry 2009 (class 2604 OID 16466)
-- Name: d_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY department ALTER COLUMN d_id SET DEFAULT nextval('department_s_id_seq'::regclass);


--
-- TOC entry 2006 (class 2604 OID 16426)
-- Name: s_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY staff ALTER COLUMN s_id SET DEFAULT nextval('staff_s_id_seq'::regclass);


--
-- TOC entry 2008 (class 2604 OID 16450)
-- Name: st_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY status ALTER COLUMN st_id SET DEFAULT nextval('status_st_id_seq'::regclass);


--
-- TOC entry 2007 (class 2604 OID 16434)
-- Name: t_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ticket ALTER COLUMN t_id SET DEFAULT nextval('ticket_t_id_seq'::regclass);


--
-- TOC entry 2148 (class 0 OID 16471)
-- Dependencies: 190
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO customer VALUES (1, 'Ahoj', 'MajSa', 2);
INSERT INTO customer VALUES (2, 'Potrebujem', 'AjInych', 4);
INSERT INTO customer VALUES (3, 'ASakMusiMi', 'NiektoAjPRSpravit', 4);
INSERT INTO customer VALUES (4, 'AchOnoTo', 'FungujeToJeSuper', 4);
INSERT INTO customer VALUES (5, 'Dokelu', 'Cestovina', 5);
INSERT INTO customer VALUES (6, 'BudemeMat', 'Plagaty', 3);
INSERT INTO customer VALUES (7, 'Miron', 'Solanka', 1);
INSERT INTO customer VALUES (8, 'Stryko', 'Drzgros', 2);
INSERT INTO customer VALUES (9, 'MocMoc', 'SaZTehtoTesim', 5);
INSERT INTO customer VALUES (10, 'Aha', 'ZnovaTestujem', 1);


--
-- TOC entry 2162 (class 0 OID 0)
-- Dependencies: 189
-- Name: customer_c_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('customer_c_id_seq', 10, true);


--
-- TOC entry 2146 (class 0 OID 16463)
-- Dependencies: 188
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO department VALUES (1, 'IT');
INSERT INTO department VALUES (2, 'Finance');
INSERT INTO department VALUES (3, 'PR');
INSERT INTO department VALUES (4, 'HR');
INSERT INTO department VALUES (5, 'Distribution');


--
-- TOC entry 2163 (class 0 OID 0)
-- Dependencies: 187
-- Name: department_s_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('department_s_id_seq', 5, true);


--
-- TOC entry 2140 (class 0 OID 16423)
-- Dependencies: 182
-- Data for Name: staff; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO staff VALUES (13, 'Jozko', 'Mrkvicka', '2016-04-08');
INSERT INTO staff VALUES (17, 'Adam', 'Druhy', '2016-04-08');
INSERT INTO staff VALUES (18, 'Teba', 'SiNecham', '2016-04-08');
INSERT INTO staff VALUES (19, 'AjTy', 'SiSuperOstanes', '2016-04-08');
INSERT INTO staff VALUES (20, 'Do', 'Tretice', '2016-04-09');
INSERT INTO staff VALUES (23, 'Na', 'Zmazanie', '2016-04-10');
INSERT INTO staff VALUES (26, 'Mazem', 'Mazaný', '2016-04-10');
INSERT INTO staff VALUES (29, 'A', 'C', '2016-04-10');
INSERT INTO staff VALUES (34, 'Lenka', 'Kobylková', '2016-04-10');
INSERT INTO staff VALUES (35, 'Emily', 'Blanc', '2016-04-10');


--
-- TOC entry 2164 (class 0 OID 0)
-- Dependencies: 181
-- Name: staff_s_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('staff_s_id_seq', 39, true);


--
-- TOC entry 2144 (class 0 OID 16447)
-- Dependencies: 186
-- Data for Name: status; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO status VALUES (1, 'New');
INSERT INTO status VALUES (2, 'In Progress');
INSERT INTO status VALUES (3, 'Done');


--
-- TOC entry 2165 (class 0 OID 0)
-- Dependencies: 185
-- Name: status_st_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('status_st_id_seq', 3, true);


--
-- TOC entry 2142 (class 0 OID 16431)
-- Dependencies: 184
-- Data for Name: ticket; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO ticket VALUES (1, 'Mlieko', 'Minulo sa mlieko asi.', '2016-04-09', '16:10:18', 18, 3, 7, '11:09:52', '2016-04-10');
INSERT INTO ticket VALUES (9, 'Na', 'Zmazanie', '2016-04-10', '15:53:59', 23, 1, 2, NULL, NULL);
INSERT INTO ticket VALUES (6, 'Testujem', 'Statistiku a ine', '2016-04-02', '12:09:12', 18, 2, 8, NULL, NULL);
INSERT INTO ticket VALUES (8, 'Testujem III', 'Statistiku', '2016-04-05', '12:09:38', 18, 2, 7, NULL, NULL);
INSERT INTO ticket VALUES (7, 'Testujem II', 'Statistiku', '2016-04-07', '12:09:28', 18, 3, 10, '17:20:42', '2016-04-10');
INSERT INTO ticket VALUES (10, 'Mazemememe', 'Skutocne to zmazeme.', '2016-04-10', '17:24:38', 26, 1, 8, NULL, NULL);
INSERT INTO ticket VALUES (12, 'A', 'A', '2016-04-10', '17:33:24', 29, 1, 7, NULL, NULL);
INSERT INTO ticket VALUES (19, 'Liskina vecera', 'Uz ma to nebavi', '2016-04-10', '19:36:58', 35, 1, 1, NULL, NULL);
INSERT INTO ticket VALUES (2, 'PokusDva', 'Customerom by mal byt 4 AchOnoTo FungujeToJeSuper a staff 13 Jozef Mrkvicka a fungovalo to', '2016-04-09', '18:12:52', 13, 2, 4, NULL, NULL);
INSERT INTO ticket VALUES (3, 'Pokus I', 'Len tak1', '2016-04-09', '22:49:34', 18, 1, 5, NULL, NULL);
INSERT INTO ticket VALUES (4, 'Pokus II', 'Len takkkkkkkkkkkkkk2', '2016-04-09', '22:49:47', 18, 2, 2, NULL, NULL);
INSERT INTO ticket VALUES (5, 'Pokus III', 'Potrebujem rozne statusy', '2016-04-09', '22:50:18', 20, 3, 2, '11:01:35', '2016-04-10');


--
-- TOC entry 2166 (class 0 OID 0)
-- Dependencies: 183
-- Name: ticket_t_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ticket_t_id_seq', 19, true);


--
-- TOC entry 2020 (class 2606 OID 16476)
-- Name: customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (c_id);


--
-- TOC entry 2018 (class 2606 OID 16468)
-- Name: department_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY department
    ADD CONSTRAINT department_pkey PRIMARY KEY (d_id);


--
-- TOC entry 2012 (class 2606 OID 16428)
-- Name: staff_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY staff
    ADD CONSTRAINT staff_pkey PRIMARY KEY (s_id);


--
-- TOC entry 2016 (class 2606 OID 16452)
-- Name: status_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY status
    ADD CONSTRAINT status_pkey PRIMARY KEY (st_id);


--
-- TOC entry 2014 (class 2606 OID 16439)
-- Name: ticket_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ticket
    ADD CONSTRAINT ticket_pkey PRIMARY KEY (t_id);


--
-- TOC entry 2024 (class 2606 OID 16477)
-- Name: customer_d_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY customer
    ADD CONSTRAINT customer_d_id_fkey FOREIGN KEY (d_id) REFERENCES department(d_id);


--
-- TOC entry 2023 (class 2606 OID 16482)
-- Name: ticket_c_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ticket
    ADD CONSTRAINT ticket_c_id_fkey FOREIGN KEY (c_id) REFERENCES customer(c_id);


--
-- TOC entry 2021 (class 2606 OID 16440)
-- Name: ticket_s_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ticket
    ADD CONSTRAINT ticket_s_id_fkey FOREIGN KEY (s_id) REFERENCES staff(s_id);


--
-- TOC entry 2022 (class 2606 OID 16453)
-- Name: ticket_st_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ticket
    ADD CONSTRAINT ticket_st_id_fkey FOREIGN KEY (st_id) REFERENCES status(st_id);


--
-- TOC entry 2155 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-04-10 23:00:54

--
-- PostgreSQL database dump complete
--

