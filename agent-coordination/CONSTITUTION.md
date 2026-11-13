# Super System — Constitución de ingeniería (SDD) v0.1
Estado: **propuesta para revisión, no aprobada** · Fecha: 2026-11-13
Documento rector de requisitos, decisiones y seguridad para el ciclo Spec-Driven Development.

## Principios vinculantes propuestos
1. **Especificaciones como fuente de verdad:** ningún requisito crítico se implementa sin ID, actor, comportamiento observable, casos de error, criterios de aceptación y evidencia de prueba. En caso de conflicto, se revisa la especificación; no se altera unilateralmente para justificar el código.
2. **Separación intención/solución:** `spec.md` describe qué y por qué; `plan.md` justifica cómo (SOA, microservicios, gateways, límites, contratos); `tasks.md` define incrementos; implementaciones y pruebas deben conformar.
3. **Arquitectura distribuida y SOA:** límites de dominio explícitos, APIs/eventos versionados, compatibilidad y propiedad del dato documentadas. Microservicios desplegables por separado cuando aporten aislamiento operativo, seguridad o escalabilidad demostrable.
4. **Zero Trust y protección de datos:** identidad autenticada y autorización por recurso, función, tenant y acción; privilegios mínimos; secretos fuera del código; cifrado; registros protegidos; controles con pruebas de fallo seguro.
5. **Security specification first:** cada capacidad requiere amenazas relevantes, invariantes de seguridad, pruebas negativas, permisos requeridos, tratamiento de errores y riesgos residuales revisados antes del merge.
6. **Adaptación con control del usuario:** perfiles explícitos, privacidad, consentimiento, accesibilidad y transparencia; la personalización jamás aumenta privilegios ni comparte contexto entre tenants.
7. **Interoperabilidad:** OpenAPI para HTTP; AsyncAPI o esquema equivalente para eventos según necesidad; compatibilidad de contratos; no acoplamiento a un LLM o gateway concreto.
8. **Trazabilidad bidireccional:** REQ ↔ SPEC ↔ ADR/contrato ↔ TASK ↔ TEST ↔ EVIDENCE ↔ RELEASE. Los cambios relevantes incrementan versión y registran impacto.
9. **Evolución controlada:** todo requisito nuevo o cambio arquitectónico importante exige evaluación de impacto, threat model, estrategia de migración y, si corresponde, ADR.
10. **No confundir artefacto con verificación:** aprobar un texto no prueba seguridad ni que exista el sistema; no publicar estado «implementado» sin resultados reproducibles.

## Flujo obligatorio: SPECIFY → CLARIFY → PLAN → VALIDATE → TASKS → ANALYZE → IMPLEMENT → CONVERGE
- **SPECIFY:** alcance, actores, historias y aceptación; sin fijar stack.
- **CLARIFY:** resolver ambigüedades y mantener supuestos visibles.
- **PLAN:** definir límites SOA, microservicios, gateways, modelo de datos, contratos API/eventos, decisiones ADR, UX y threat model.
- **VALIDATE:** checklist de completitud, coherencia, accesibilidad, privacidad y seguridad; revisión independiente.
- **TASKS:** dependencias y entregables ordenados, cada tarea vinculada a requisitos y pruebas.
- **ANALYZE:** detectar inconsistencias y requisitos huérfanos entre artefactos; no modificar código.
- **IMPLEMENT:** código y pruebas derivados de especificaciones acordadas, con controles automáticos.
- **CONVERGE:** comparar implementación con spec, evidencias y contratos, documentar diferencias y cerrar solo cuando cumple.

## Regla de entrada a implementación (Gate 0)
- [ ] Spec con requisitos identificados (REQ-###), actores, casos excepcionales y aceptación verificable.
- [ ] Supuestos sin resolver registrados; ninguno bloqueante.
- [ ] Dependencias, límites de servicio, contratos y ADR evaluados.
- [ ] Threat model y análisis de privacidad revisados para el alcance.
- [ ] Especificaciones UI con estados vacío/carga/error, accesibilidad y permisos.
- [ ] Tareas y pruebas trazadas a los requisitos.
- [ ] Decisión humana explícita de comenzar implementación.

## Regla de salida (Definition of Done propuesto)
- [ ] Se ejecutaron pruebas de unidad, integración, contrato y seguridad previstas.
- [ ] Evidencia verificable de cada criterio de aceptación.
- [ ] Sin acceso cruzado entre tenants ni acciones externas sin autorización en escenarios ensayados.
- [ ] Logs y trazas verifican quién hizo qué, con redacción de datos sensibles.
- [ ] Revisión de compatibilidad de contratos, rollback y migración.
- [ ] Auditoría de desviaciones, riesgos residuales y aprobación humana documentadas.

## Fuente de referencia
- GitHub Spec Kit: https://github.github.com/spec-kit/
- OpenAPI Specification: https://spec.openapis.org/oas/
- NIST SP 800-207: https://www.nist.gov/publications/zero-trust-architecture
- OWASP ASVS: https://asvs.owasp.org/
- WCAG 2.2: https://www.w3.org/TR/WCAG22/

Esta constitución es **propuesta**. Las herramientas Spec Kit y el pipeline aún no se instalaron ni ejecutaron.
