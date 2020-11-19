package test.bucket.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import test.bucket.entity.Note
import test.bucket.repositories.NoteRepository

@RestController
@RequestMapping("notes")
class NoteController {

    @Autowired
    lateinit var noteRepository: NoteRepository

    @GetMapping
    fun list(): List<Note> = noteRepository.findAll().toList()

    @PostMapping
    fun add(@RequestBody note: Note):Note = noteRepository.save(note)
}