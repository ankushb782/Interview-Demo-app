import com.interview.erakulis.data.ImageRepository
import com.interview.erakulis.data.ImageRepositoryImpl
import com.interview.erakulis.data.UserRepositoryImpl
import com.interview.erakulis.domain.GetImageDetailUseCase
import com.interview.erakulis.domain.LoginUseCase
import com.interview.erakulis.data.UserRepository
import org.koin.dsl.module

val appModule = module {

    // Provide UserRepository
    single<UserRepository> { UserRepositoryImpl() }

    // Provide LoginUseCase
    single { LoginUseCase(get()) }

    // Provide ImageRepository
    single<ImageRepository> { ImageRepositoryImpl() }

    // Provide GetImageDetailUseCase
    single { GetImageDetailUseCase(get()) }
}
