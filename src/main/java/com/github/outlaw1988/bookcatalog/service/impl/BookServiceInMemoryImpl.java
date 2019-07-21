package com.github.outlaw1988.bookcatalog.service.impl;

import com.github.outlaw1988.bookcatalog.model.Book;
import com.github.outlaw1988.bookcatalog.service.BookService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Primary
@Service
public class BookServiceInMemoryImpl implements BookService {

    private Map<Long, Book> books;

    {
        books = new HashMap<>();
        books.put(1L, new Book(1L,
                "Python dla każdego. Podstawy programowania",
                "45234523",
                "Chcesz się nauczyć programować? Świetna decyzja! Wybierz język obiektowy, łatwy w użyciu, " +
                        "z przejrzystą składnią. Python będzie wprost doskonały! Rozwijany od ponad 20 lat, " +
                        "jest dojrzałym językiem, pozwalającym tworzyć zaawansowane aplikacje dla różnych systemów " +
                        "operacyjnych. Ponadto posiada system automatycznego zarządzania pamięcią, który zdejmuje " +
                        "z programisty obowiązek panowania nad tym skomplikowanym obszarem.",
                "2014"));

        books.put(2L, new Book(2L,
                "Czysty kod. Podręcznik dobrego programisty",
                "54325342",
                "Poznaj najlepsze metody tworzenia doskonałego kodu",
                "2014"));

        books.put(3L, new Book(3L,
                "Programista samouk. Profesjonalny przewodnik do samodzielnej nauki kodowania",
                "634565",
                "Nie wystarczy znajomość jednego języka programowania, aby zostać programistą. " +
                        "W rzeczywistości trzeba opanować dość szeroki zakres pojęć i paradygmatów, a także zrozumieć " +
                        "zagadnienia związane z algorytmami. Trzeba być na bieżąco z nowymi technologiami i narzędziami. " +
                        "Należy również poznać i zacząć stosować dobre praktyki programistyczne i przyswoić sobie zasady " +
                        "pracy w zespole. Przede wszystkim jednak priorytetem jest sama praktyka, ponieważ wielu programistów " +
                        "wciąż ma problem z pisaniem poprawnego kodu.",
                "2017"));
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book getBook(Long id) {
        return books.get(id);
    }

    @Override
    public void removeBook(Long id) {
        books.remove(id);
    }

    @Override
    public void addBook(Book book) {
        Long id = getIdToUse();
        book.setId(id);
        System.out.println(book);
        books.put(id, book);
    }

    private Long getIdToUse() {
        Long maxId = Collections.max(books.keySet());
        return ++maxId;
    }

}
