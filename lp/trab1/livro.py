#!/usr/bin/env python
# -*- coding: utf-8 -*-

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

    def getCodigo(self):
        return self.__codigo

    def getTitulo(self):
        return self.__titulo

    def getAutor(self):
        return self.__autor

    def getData(self):
        return self.__dataPub

    def getDados(self):
        dados = [self.__codigo] + [self.__titulo] + [self.__autor] + [self.__assunto] + [self.__dataPub.strftime("%d/%m/%y")] + [self.__editora] + [self.__resumo]
        return dados

    def alteraDados(self, codigo, titulo, autor, assunto, dataPub, editora, resumo):
        self.__codigo = codigo
        self.__titulo = titulo
        self.__autor = autor
        self.__assunto = assunto
        self.__dataPub = dataPub
        self.__editora = editora
        self.__resumo = resumo

    @staticmethod
    def comparaCodigo(livro1, livro2):
        cod1 = livro1.getCodigo()
        cod2 = livro2.getCodigo()

        if cod1 < cod2:
            return -1
        elif cod1 == cod2:
            return 0
        else:
            return 1

    @staticmethod
    def comparaTitulo(livro1, livro2):
        titulo1 = livro1.getTitulo()
        titulo2 = livro2.getTitulo()

        if titulo1 < titulo2:
            return -1
        elif titulo1 == titulo2:
            return Livro.comparaCodigo(livro1, livro2)
        else:
            return 1

    @staticmethod
    def comparaAutor(livro1, livro2):
        autor1 = livro1.getAutor()
        autor2 = livro2.getAutor()

        if autor1 > autor2:
            return -1
        elif autor1 == autor2:
            return Livro.comparaCodigo(livro1, livro2)
        else:
            return 1

    @staticmethod
    def comparaData(livro1, livro2):
        data1 = livro1.getData()
        data2 = livro2.getData()

        if data1 > data2:
            return -1
        elif data1 == data2:
            return Livro.comparaCodigo(livro1, livro2)
        else:
            return 1
