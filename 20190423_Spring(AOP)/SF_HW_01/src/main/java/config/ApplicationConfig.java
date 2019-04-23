package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ssafy.model.repository.BookRepository;
import com.ssafy.model.service.BookService;

@Configuration //설정 파일임을 표시
@ComponentScan(basePackageClasses={BookRepository.class, BookService.class})// 패키지를 스캔
public class ApplicationConfig {

}
