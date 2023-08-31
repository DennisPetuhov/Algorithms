
data class User(val name:String)
interface UserDataSource {
    fun save(user: User)
}

class RemoteUserDataSource : UserDataSource {
    override fun save(user: User) {
        println("Calling save in remote data source.")
    }
}

class FakeUserDataSource : UserDataSource {
    override fun save(user: User) {
        println("Calling save in fake data source.")
    }
}
class UserRepository(
    private val userDataSource: UserDataSource
) {
    fun save(user: User) {
        userDataSource.save(user)
    }
}

fun main() {
    val user = User("Abhishek Saxena")

    val fakeUserDataSource = FakeUserDataSource()
    val userRepositoryWithFakeDataSource = UserRepository(fakeUserDataSource)
    userRepositoryWithFakeDataSource.save(user) // Calling save in fake data source.

    val remoteUserDataSource = RemoteUserDataSource()
    val userRepositoryWithRemoteDataSource = UserRepository(remoteUserDataSource)
    userRepositoryWithRemoteDataSource.save(user) // Calling save in remote data source.
}