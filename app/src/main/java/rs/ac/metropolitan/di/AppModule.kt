package rs.ac.metropolitan.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import rs.ac.metropolitan.data.data_source.TravelDatabase
import rs.ac.metropolitan.data.repository.TravelRepositoryImpl
import rs.ac.metropolitan.domain.repository.TravelRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTravelDatabase(app: Application): TravelDatabase {
        return Room.databaseBuilder(
            app,
            TravelDatabase::class.java,
            TravelDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTravelRepository(db: TravelDatabase): TravelRepository {
        return TravelRepositoryImpl(db.travelDao)
    }
}