SUMMARY = "Web UI package"
DESCRIPTION = "Package containing a single HTML file and a service for the web UI"
LICENSE = "CLOSED"
SRC_URI = "file://index.html \
           file://web-ui.service"

PACKAGES = "${PN} ${PN}-service"

FILES_${PN} = "/var/www/html/index.html"
FILES_${PN}-service = "/usr/lib \
                       /usr/lib/systemd \
                       /usr/lib/systemd/system \
                       /usr/lib/systemd/system/web-ui.service"
                       

do_install() {
    install -D ${WORKDIR}/sources-unpack/index.html ${D}/var/www/html/index.html
    install -D ${WORKDIR}/sources-unpack/web-ui.service ${D}${systemd_system_unitdir}/web-ui.service
}


SYSTEMD_SERVICE_${PN}-service = "web-ui.service"

