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
comparaLivroPorCodigo l1 l2
    | cod1 <= cod2  = True
    | otherwise     = False

    where cod1 = read (codigo l1) :: Int
          cod2 = read (codigo l2) :: Int

-- 2. por título (decrescente):
comparaLivroPorTitulo l1 l2
    | titulo l1 > titulo l2   = True
    | titulo l1 == titulo l2  = not (comparaLivroPorCodigo l1 l2)
    | otherwise               = False

-- 3. por autor (crescente):
comparaLivroPorAutor l1 l2
    | autor l1 < autor l2   = True
    | autor l1 == autor l2  = comparaLivroPorCodigo l1 l2
    | otherwise             = False

-- 3. por data (decrescente):
comparaLivroPorData l1 l2
    | dataPub l1 > dataPub l2   = True
    | dataPub l1 == dataPub l2  = not (comparaLivroPorCodigo l1 l2)
    | otherwise                 = False
