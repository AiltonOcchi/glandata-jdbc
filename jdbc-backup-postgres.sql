PGDMP          %                z            jdbc    14.1    14.1     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    53685    jdbc    DATABASE     d   CREATE DATABASE jdbc WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE jdbc;
                jdbc    false            ?            1259    53687    produto    TABLE     v   CREATE TABLE public.produto (
    id integer NOT NULL,
    nome character varying,
    descricao character varying
);
    DROP TABLE public.produto;
       public         heap    jdbc    false            ?            1259    53686    produto_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.produto_id_seq;
       public          jdbc    false    210            ?           0    0    produto_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id;
          public          jdbc    false    209            \           2604    53690 
   produto id    DEFAULT     h   ALTER TABLE ONLY public.produto ALTER COLUMN id SET DEFAULT nextval('public.produto_id_seq'::regclass);
 9   ALTER TABLE public.produto ALTER COLUMN id DROP DEFAULT;
       public          jdbc    false    210    209    210            ?          0    53687    produto 
   TABLE DATA           6   COPY public.produto (id, nome, descricao) FROM stdin;
    public          jdbc    false    210   
       ?           0    0    produto_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.produto_id_seq', 1, true);
          public          jdbc    false    209            ^           2606    53694    produto produto_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_pkey;
       public            jdbc    false    210            ?      x?3???"?=... EJ     