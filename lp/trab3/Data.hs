--
-- Data.hs
--
-- Definição e implementação da
-- classe Data e suas funções
--

-- Definição do módulo Data
module Data
( Data(..)
) where

-- Definição da estrutura Data
data Data = Data {
    dia :: Int,
    mes :: Int,
    ano :: Int
} deriving (Show, Eq)


--instance Ord Data where
    --compare (Data a b c) (Data d e f) = a > b
