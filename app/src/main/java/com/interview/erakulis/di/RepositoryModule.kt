import com.interview.erakulis.data.UserRepositoryImpl
import com.interview.erakulis.data.UserRepository
import org.koin.dsl.module

val repositoryModule = module {

    // Provide UserRepository using single to create a singleton instance
    single<UserRepository> { UserRepositoryImpl() }
}
