package dio.taskmanager.infrastructure.repository;


import dio.taskmanager.domain.TaskRepository;
import dio.taskmanager.domain.TaskRepositoryTest;

class InMemoryTaskRepositoryTest extends TaskRepositoryTest {
    @Override
    protected TaskRepository createRepository() {
        return new InMemoryTaskRepository();
    }
}
