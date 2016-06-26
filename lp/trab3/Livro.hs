--
-- Livro.hs
--
-- Definição e implementação da
-- classe Livro e suas funções
--

-- Definição do módulo Livro
module Livro
( Livro(..)
, comparaLivroPorCodigo
, comparaLivroPorTitulo
, comparaLivroPorAutor
, comparaLivroPorData
) where

-- Importando Data.hs
import Data

-- Definição da estrutura Livro
data Livro  = Livro {
    codigo  :: String,
    titulo  :: String,
    autor   :: String,
    assunto :: String,
    dataPub :: Data,
    editora :: String,
    resumo  :: String
}

-- Como mostrar um Livro
instance Show Livro where
    show (Livro c t a ass d e r) = id c ++ "\n" ++ id t ++ "\n" ++ id a ++ "\n" ++ id ass ++ "\n" ++ show d ++ "\n" ++ id e ++ "\n" ++ id r

-- Como comparar um Livro...
-- 1. por código (crescente):
comparaLivroPorCodigo (Livro c1 _ _ _ _ _ _) (Livro c2 _ _ _ _ _ _)
    | cod1 <= cod2  = True
    | otherwise     = False
    where cod1 = read c1 :: Int
          cod2 = read c2 :: Int

-- 2. por título (decrescente):
comparaLivroPorTitulo (Livro c1 t1 a1 ass1 d1 e1 r1) (Livro c2 t2 a2 ass2 d2 e2 r2)
    | t1 > t2   = True
    | t1 == t2  = not (comparaLivroPorCodigo (Livro c1 t1 a1 ass1 d1 e1 r1) (Livro c2 t2 a2 ass2 d2 e2 r2))
    | otherwise = False

-- 3. por autor (crescente):
comparaLivroPorAutor (Livro c1 t1 a1 ass1 d1 e1 r1) (Livro c2 t2 a2 ass2 d2 e2 r2)
    | a1 < a2   = True
    | a1 == a2  = comparaLivroPorCodigo (Livro c1 t1 a1 ass1 d1 e1 r1) (Livro c2 t2 a2 ass2 d2 e2 r2)
    | otherwise = False

-- 3. por data (decrescente):
comparaLivroPorData (Livro c1 t1 a1 ass1 d1 e1 r1) (Livro c2 t2 a2 ass2 d2 e2 r2)
    | d1 > d2   = True
    | d1 == d2  = not (comparaLivroPorCodigo (Livro c1 t1 a1 ass1 d1 e1 r1) (Livro c2 t2 a2 ass2 d2 e2 r2))
    | otherwise = False
