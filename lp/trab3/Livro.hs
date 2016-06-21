--
-- Livro.hs
--
-- Definição e implementação da
-- classe Livro e suas funções
--

-- Definição do módulo Livro
module Livro
( Livro(..)
--, toString
) where

-- Importando Data.hs
import Data

-- Definição da estrutura Livro
data Livro  = Livro {
    codigo  :: Int,
    titulo  :: String,
    autor   :: String,
    assunto :: String,
    dataPub :: Data,
    editora :: String,
    resumo  :: String
} deriving (Show, Eq)

-- Função que imprime os dados de um livro
--toString :: Livro -> IO()
--toString (Livro c t a ass d e r) = putStr(show c ++ "\n" ++ t ++ "\n" ++ a ++ "\n"  ++ ass ++ "\n" ++ d ++ "\n" ++ e ++ "\n" ++ r ++ "\n")
