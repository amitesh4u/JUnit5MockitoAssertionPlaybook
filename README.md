## Sample JUnit5 code with Mockito, Assertion libraries like AssertJ, Hamcrest

## Coverage by Jacoco plugin


### JUnit 4 to 5 migration core change

**Junit 4**
```
@RunWith(MockitoJUnitRunner.class, SpringRunner.class)
```
**Junit 5**
```
@ExtendWith(MockitoExtension.class, SpringExtension.class)
```