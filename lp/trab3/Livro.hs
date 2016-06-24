--
-- Livro.hs
--
-- Definição e implementação da
-- classe Livro e suas funções
--

-- Definição do módulo Livro
module Livro
( Livro(..)
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
}

-- Como mostrar um Livro
instance Show Livro where
    show (Livro c t a ass d e r) = show c ++ "\n" ++ id t ++ "\n" ++ id a ++ "\n" ++ id ass ++ "\n" ++ show d ++ "\n" ++ id e ++ "\n" ++ id r

