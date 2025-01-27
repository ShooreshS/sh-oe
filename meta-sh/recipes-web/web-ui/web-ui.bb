SUMMARY = "Web UI package"
DESCRIPTION = "Package containing a single HTML file and a service for the web UI"
LICENSE = "CLOSED"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI = "file://index.html \
           file://web-ui.service"

#PACKAGES = "${PN} ${PN}-service"

S = "${WORKDIR}/sources-unpack"


do_install() {
    install -D ${S}/index.html ${D}/var/www/html/index.html
    install -D ${S}/web-ui.service ${D}/etc/systemd/system/web-ui.service
    
    echo "DEBUG: Installed files:"
    find ${D}
}

FILES_${PN} = "/var/www/html/index.html \
               /etc/systemd/system/web-ui.service"
                       

SYSTEMD_SERVICE_${PN}-service = "web-ui.service"
SYSTEMD_AUTO_ENABLE_${PN}-service = "enable"

