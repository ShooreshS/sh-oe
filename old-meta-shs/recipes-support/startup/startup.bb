SUMMARY = "Startup script and service"
DESCRIPTION = "A package that provides a startup script and service for the system"
LICENSE = "CLOSED"
SRC_URI = "file://startup.sh \
           file://startup.service"

do_install() {
    install -D ${WORKDIR}/startup.sh ${D}/etc/startup.sh
    install -D ${WORKDIR}/startup.service ${D}${systemd_system_unitdir}/startup.service
}

FILES_${PN} = "/etc/startup.sh ${systemd_system_unitdir}/startup.service"

SYSTEMD_SERVICE:${PN} = "startup.service"

