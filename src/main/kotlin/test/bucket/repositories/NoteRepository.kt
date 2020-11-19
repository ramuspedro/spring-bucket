package test.bucket.repositories

import org.springframework.data.repository.CrudRepository
import test.bucket.entity.Note

interface NoteRepository : CrudRepository<Note, Long>