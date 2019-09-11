package ru.ramazanov.TestTask.domain;

import lombok.*;

import javax.persistence.*;


/**
 * Класс результата поиска.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "result")
public class FindResultEntity {

    /**
     * @param id - уникальный id
     * @param sysCode - код выполнения операции {@link SystemCode}
     * @param number - число по которому производится поиск
     * @param fileName - список файлов в которых было найдено данное число
     * @param error - сообщение ошибки
     */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_sequence_generator")
    @SequenceGenerator(name = "document_sequence_generator", sequenceName = "acc_document_id_seq", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CODE", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private SystemCode sysCode;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "FILENAME", length = 100)
    private String fileName;

    @Column(name = "ERROR", length = 100)
    private String error;
}
