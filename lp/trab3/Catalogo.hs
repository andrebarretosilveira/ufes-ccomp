--
-- Catalogo.hs
--
-- Definição e implementação da
-- classe Catalogo e suas funções
--

-- Importando funções de Livro.hs
import Livro

-- Definição da estrutura Catalogo
data Catalogo = Catalogo {
    livros :: [Livro]
} deriving (Show)

-- Função de leitura de um livro
--lerLivro filename = 

-- Função para adicionar um livro do Catálago
adicionaLivro :: [Livro] -> Livro -> [Livro]
adicionaLivro xs (Livro c t a ass d e r) = xs ++ [Livro c t a ass d e r]
