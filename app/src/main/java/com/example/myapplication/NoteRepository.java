package com.example.myapplication;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> notes;

    ExecutorService executors= Executors.newSingleThreadExecutor();

    public NoteRepository(Application application){
        NoteDatabase database=NoteDatabase.getInstance(application);
        noteDao=database.noteDao();
        notes=noteDao.getAllNotest();
    }

    public void insert(Note note){

        executors.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.inser(note);
            }
        });
       // new InsertNoteAsyncTask(noteDao).execute(note);
    }

    public void update(Note note){
        executors.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.update(note);
            }
        });
        //new UpdateNoteAsyncTask(noteDao).execute(note);
    }
    public void delete(Note note){
        executors.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.delete(note);
            }
        });
        //new DeleteNoteAsyncTask(noteDao).execute(note);
    }
    public LiveData<List<Note>> getAllNotes(){
     return  notes;
    }
    private static class InsertNoteAsyncTask extends AsyncTask<Note,Void,Void> {
        private NoteDao noteDao;

        private InsertNoteAsyncTask(NoteDao noteDao){
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.inser(notes[0]);
            return null;
        }
    }
  /*
    private static class UpdateNoteAsyncTask extends AsyncTask<Note,Void,Void> {
        private NoteDao noteDao;

        private UpdateNoteAsyncTask(NoteDao noteDao){
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.inser(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Note,Void,Void> {
        private NoteDao noteDao;

        private DeleteNoteAsyncTask(NoteDao noteDao){
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.inser(notes[0]);
            return null;
        }
    }
    */

}
