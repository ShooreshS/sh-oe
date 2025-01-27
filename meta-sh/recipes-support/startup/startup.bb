SUMMARY = "Startup script and service"
DESCRIPTION = "A package that provides a startup script and service for the system"
LICENSE = "CLOSED"

inherit systemd
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = " \
    file://startup.sh \
    file://startup.service \
"

# You typically don't need S overridden unless there's a real reason
S = "${WORKDIR}/sources-unpack"

do_install() {
    install -D -m 0755 ${S}/startup.sh ${D}/etc/startup.sh

    install -D -m 0644 ${S}/startup.service \
        ${D}/etc/systemd/system/startup.service
}

# Explicitly list which files go into the main package
FILES_${PN} += " \
    /usr/lib/systemd/system/ \
    /etc/startup.sh \
    /etc/systemd/system/startup.service \
"

# Systemd-specific settings
SYSTEMD_SERVICE_${PN} = "startup.service"
SYSTEMD_AUTO_ENABLE = "enable"

