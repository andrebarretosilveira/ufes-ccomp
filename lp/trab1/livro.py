#!/usr/bin/env python
# -*- coding: utf-8 -*-

###
#   livro.py
#
#   Definição e implementação da
#   classe Livro e suas funções
###

from datetime import date

class Livro:
    def __init__(self, codigo, titulo, autor, assunto, dataPub, editora, resumo):
        self.__codigo = codigo
        self.__titulo = titulo
        self.__autor = autor
        self.__assunto = assunto
        self.__dataPub = dataPub
        self.__editora = editora
        self.__resumo = resumo

    # Retorna o código do livro
    def getCodigo(self):
        return self.__codigo

    # Retorna o título do livro
    def getTitulo(self):
        return self.__titulo

    # Retorna o autor do livro
    def getAutor(self):
        return self.__autor

    # Retorna a data de publicação do livro
    def getData(self):
        return self.__dataPub

    # Retorna os dados do livro em uma lista
    def getDados(self):
        dados = [self.__codigo] + [self.__titulo] + [self.__autor] + [self.__assunto] + [self.__dataPub.strftime("%d/%m/%Y")] + [self.__editora] + [self.__resumo]
        return dados

    @staticmethod #Compara crescentemente por Código
    def comparaCodigo(livro1, livro2):
        cod1 = int(livro1.getCodigo())
        cod2 = int(livro2.getCodigo())

        if cod1 < cod2:
            return -1
        elif cod1 == cod2:
            return 0
        else:
            return 1

    @staticmethod #Compara decrescentemente por Título
    def comparaTitulo(livro1, livro2):
        titulo1 = livro1.getTitulo()
        titulo2 = livro2.getTitulo()

        if titulo1 > titulo2:
            return -1
        elif titulo1 == titulo2:
            return (-1)*Livro.comparaCodigo(livro1, livro2)
        else:
            return 1

    @staticmethod #Compara crescentemente por Autor
    def comparaAutor(livro1, livro2):
        autor1 = livro1.getAutor()
        autor2 = livro2.getAutor()

        if autor1 < autor2:
            return -1
        elif autor1 == autor2:
            return Livro.comparaCodigo(livro1, livro2)
        else:
            return 1

    @staticmethod #Compara decrescentemente por Data
    def comparaData(livro1, livro2):
        data1 = livro1.getData()
        data2 = livro2.getData()

        if data1 > data2:
            return -1
        elif data1 == data2:
            return (-1)*Livro.comparaCodigo(livro1, livro2)
        else:
            return 1
