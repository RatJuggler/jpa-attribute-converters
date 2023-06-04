# jpa-attribute-converters

Experimenting with JPA Attribute Converters.

Useful links:

- <https://thorben-janssen.com/jpa-attribute-converter/>
- <https://vladmihalcea.com/jpa-attributeconverter/>
- <https://thorben-janssen.com/how-to-use-jpa-type-converter-to/>, alternate link to the article referenced: <https://www.javacodegeeks.com/2012/11/database-encryption-using-jpa-listeners.html>

Pros

- Can be targeted to specific entity attributes.
- Easy to understand, no edge case side effects.
- Simple to implement and maintain.
- Doesn't leave the presistence session / entity in a dirty state.
- JPA compliant.

Cons

- MAJOR: No access to the entity the attribute being converted belongs to.
