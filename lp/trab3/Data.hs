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
    dia :: String,
    mes :: String,
    ano :: String
} deriving (Eq)

-- Como mostrar uma Data
instance Show Data where
    show (Data dia mes ano) = id dia ++ "/" ++ id mes ++ "/" ++ id ano

-- Como comparar Datas
instance Ord Data where
    compare (Data a b c) (Data d e f) = (c++b++a) `compare` (f++e++d)
