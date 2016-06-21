--
-- Catalogo.hs
--
-- Definição e implementação da
-- classe Catalogo e suas funções
--

-- Definição do módulo Catalogo
module Catalogo
( Catalogo(..)
, adicionaLivro
, livroFromList
, criaListaLivros
, splitOn
) where

-- Importando Livro.hs
import Livro
import Data

-- Definição da estrutura Catalogo
data Catalogo = Catalogo {
    livros :: [Livro]
} deriving (Show)

-- Função que cria a lista de livros
criaListaLivros _ [] = []
criaListaLivros l xss = adicionaLivro l (livroFromList (head xss)) ++ criaListaLivros l (tail xss)

-- Função de leitura de um livro
livroFromList xs = Livro (read (xs!!0) :: Int) (xs!!1) (xs!!2) (xs!!3) dataPub (xs!!5) (xs!!6)
    where dataPub = Data (read dia :: Int) (read mes :: Int) (read ano :: Int)
          [dia,mes,ano] = splitOn '/' (xs!!4)

-- Função para adicionar um livro em uma lista
adicionaLivro xs (Livro c t a ass d e r) = xs ++ [Livro c t a ass d e r]

-- Separar uma lista de strings em uma lista de lista de strings
splitOn _ [] = []
splitOn delim l@(x:xs)
 	| x==delim = splitOn delim xs
	| otherwise =  h:(splitOn delim t)
		where (h,t) = break (\a -> a==delim) l
